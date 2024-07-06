package com.example.mypokemonapplication.presentation.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mypokemonapplication.presentation.viewmodel.PokemonsViewModel

@Composable
fun MainScreen(
    viewModel: PokemonsViewModel
) {
    val allPokemonsUiState by viewModel.pokemonsUiState.collectAsStateWithLifecycle()
    MainScreenContent(
        allPokemonsUiState = allPokemonsUiState
    )
}