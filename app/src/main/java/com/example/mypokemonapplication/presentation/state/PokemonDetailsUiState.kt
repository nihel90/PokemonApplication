package com.example.mypokemonapplication.presentation.state

import com.example.mypokemonapplication.domain.model.PokemonDetailsEntity

sealed interface PokemonDetailsUiState {

    data object Idle : PokemonDetailsUiState
    data class Ready(val pokemonsDetails: PokemonDetailsEntity) : PokemonDetailsUiState
    data object Error : PokemonDetailsUiState
}