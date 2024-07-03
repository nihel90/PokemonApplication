package com.example.mypokemonapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mypokemonapplication.core.Result
import com.example.mypokemonapplication.core.di.IoDispatcher
import com.example.mypokemonapplication.domain.interactor.PokemonsInteractor
import com.example.mypokemonapplication.presentation.state.PokemonsUiState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonsViewModel @Inject constructor(
    private val interactor: PokemonsInteractor,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _pokemonsUiState =
        MutableStateFlow<PokemonsUiState>(value = PokemonsUiState.Loading)
    val pokemonsUiState: StateFlow<PokemonsUiState> = _pokemonsUiState

    fun getAllLeagues() = viewModelScope.launch(context = dispatcher) {
        _pokemonsUiState.value = interactor.getAllPokemons().let { pokemons ->
            if (pokemons is Result.Success) {
                PokemonsUiState.Ready(pokemons = pokemons.data.map { it.name })
            } else {
                PokemonsUiState.Error
            }
        }
    }
}