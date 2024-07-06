package com.example.mypokemonapplication.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mypokemonapplication.presentation.state.PokemonsUiState
import com.example.mypokemonapplication.presentation.view.composable.AutoCompleteSearchBar
import com.example.mypokemonapplication.presentation.view.composable.CircularLoader
import com.example.mypokemonapplication.presentation.view.composable.CommonGeneralError
import com.example.mypokemonapplication.presentation.view.composable.ScreenContent

 const val COLUMNS_NUMBER = 2

@Composable
fun MainScreenContent(
    allPokemonsUiState: PokemonsUiState,
) {
    ScreenContent(hasToolbar = false) {
        var allPokemons by remember { mutableStateOf(emptyList<String>()) }
        val isUserTyping = remember { mutableStateOf(false) }
        var isSearching by remember { mutableStateOf(false) }
        var isPokemonsLoading by remember { mutableStateOf(false) }
        val isGeneralCommonErrorDialogVisible = remember { mutableStateOf(false) }

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
                    },
                )

                if (isSearching) {
                    CircularLoader()
                } else {
                    LazyVerticalGrid(
                        modifier = Modifier
                            .blur(if (isUserTyping.value) 12.dp else 0.dp)
                            .fillMaxSize()
                            .background(if (isUserTyping.value) Color.LightGray else Color.White),
                        columns = GridCells.Fixed(COLUMNS_NUMBER)
                    ) {

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
    )
}