package com.example.mypokemonapplication.domain.interactor

import com.example.mypokemonapplication.domain.repository.PokemonDetailsRepository
import com.example.mypokemonapplication.domain.repository.PokemonsRepository
import javax.inject.Inject

class PokemonsInteractor @Inject constructor(
    private val pokemonsRepository: PokemonsRepository,
    private val pokemonDetailsRepository: PokemonDetailsRepository
) {

    suspend fun getAllPokemons() = pokemonsRepository.fetchAllPokemons()

    suspend fun getPokemonsDetails(name: String) =
        pokemonDetailsRepository.fetchPokemonByName(name = name)
}