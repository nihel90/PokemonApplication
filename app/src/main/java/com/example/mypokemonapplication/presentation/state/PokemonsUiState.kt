package com.example.mypokemonapplication.presentation.state

sealed interface PokemonsUiState {
    data object Idle : PokemonsUiState
    data object Loading: PokemonsUiState
    data class Ready(val pokemons: List<String>): PokemonsUiState
    data object Error : PokemonsUiState
}