package com.example.mypokemonapplication.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mypokemonapplication.domain.model.Abilities
import com.example.mypokemonapplication.domain.model.Ability
import com.example.mypokemonapplication.domain.model.PokemonDetailsEntity
import com.example.mypokemonapplication.domain.model.Sprites
import com.example.mypokemonapplication.presentation.state.PokemonDetailsUiState
import com.example.mypokemonapplication.presentation.state.PokemonsUiState
import com.example.mypokemonapplication.presentation.view.composable.AsyncImage
import com.example.mypokemonapplication.presentation.view.composable.AutoCompleteSearchBar
import com.example.mypokemonapplication.presentation.view.composable.CircularLoader
import com.example.mypokemonapplication.presentation.view.composable.CommonGeneralError
import com.example.mypokemonapplication.presentation.view.composable.ScreenContent

@Composable
fun MainScreenContent(
    allPokemonsUiState: PokemonsUiState,
    pokemonDetailsUiState: PokemonDetailsUiState,
    onPokemonSearch: (String) -> Unit,
) {
    ScreenContent(hasToolbar = false) {
        var allPokemons by remember { mutableStateOf(emptyList<String>()) }
        val isUserTyping = remember { mutableStateOf(false) }
        var isSearching by remember { mutableStateOf(false) }
        var isPokemonsLoading by remember { mutableStateOf(false) }
        val isGeneralCommonErrorDialogVisible = remember { mutableStateOf(false) }
        var pokemonDetails by remember { mutableStateOf(PokemonDetailsEntity()) }

        when (allPokemonsUiState) {
            is PokemonsUiState.Idle -> Unit
            is PokemonsUiState.Loading -> isPokemonsLoading = false
            is PokemonsUiState.Ready -> {
                isPokemonsLoading = false
                allPokemons = allPokemonsUiState.pokemons
            }

            is PokemonsUiState.Error -> {
                isPokemonsLoading = true
                isGeneralCommonErrorDialogVisible.value = true
            }
        }

        when (pokemonDetailsUiState) {
            PokemonDetailsUiState.Idle -> Unit
            is PokemonDetailsUiState.Ready -> {
                isSearching = false
                pokemonDetails = pokemonDetailsUiState.pokemonsDetails
            }

            PokemonDetailsUiState.Error -> {
                isGeneralCommonErrorDialogVisible.value = true
                isSearching = false
            }
        }

        if (isPokemonsLoading) {
            CircularLoader()
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Color.White
                    )
            ) {
                AutoCompleteSearchBar(
                    modifier = Modifier.fillMaxWidth(),
                    items = allPokemons,
                    isUserTyping = isUserTyping,
                    onSearchClicked = {
                        isSearching = true
                        onPokemonSearch(it)
                    },
                )
                if (isSearching) {
                    CircularLoader()

                } else {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AsyncImage(url = pokemonDetails.sprites?.frontDefault.toString())
                        pokemonDetails.name?.let { pokemonDetails ->
                            Text(
                                modifier = Modifier
                                    .padding(top = 8.dp)
                                    .fillMaxWidth(),
                                text = pokemonDetails,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                fontSize = 24.sp
                            )
                        }
                    }
                }

            }
        }
        CommonGeneralError(
            shouldShowDialogState = isGeneralCommonErrorDialogVisible,
        )
    }
}

@Preview(name = "MainScreen")
@Composable
fun MainScreenPreview() {
    MainScreenContent(
        allPokemonsUiState = PokemonsUiState.Ready(
            pokemons = listOf(
                "Bolbasaur",
                "Pikatchu",
                "Bolbasaur",
                "Pikatchu"
            )
        ),
        pokemonDetailsUiState = PokemonDetailsUiState.Ready(
            pokemonsDetails = PokemonDetailsEntity(
                id = 5,
                name = "Bulbasaur",
                height = 187,
                url = "https://bulbasaur.com",
                abilities = listOf(
                    Abilities
                        (Ability(name = null, url = null)),
                    Abilities
                        (Ability(name = "name1", url = "url1"))
                ),
                sprites = Sprites()
            )
        ),
        onPokemonSearch = {}
    )
}