package com.example.mypokemonapplication.domain.interactor

import com.example.mypokemonapplication.domain.repository.PokemonsRepository
import javax.inject.Inject

class PokemonsInteractor @Inject constructor(
    private val pokemonsRepository: PokemonsRepository
) {

    suspend fun getAllPokemons() = pokemonsRepository.fetchAllPokemons()
}