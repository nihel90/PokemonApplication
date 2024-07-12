package com.example.mypokemonapplication.presentation.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mypokemonapplication.presentation.viewmodel.PokemonsViewModel

@Composable
fun MainScreen(
    viewModel: PokemonsViewModel,
    onPokemonClick: (String) -> Unit
) {
    val allPokemonsUiState by viewModel.pokemonsUiState.collectAsStateWithLifecycle()
    val pokemonDetailsUiState by viewModel.pokemonDetailsUiState.collectAsStateWithLifecycle()

    MainScreenContent(
        allPokemonsUiState = allPokemonsUiState,
        pokemonDetailsUiState = pokemonDetailsUiState,
        onPokemonSearch = { viewModel.getPokemonDetails(name = it) },
        onPokemonClick = onPokemonClick
    )
}