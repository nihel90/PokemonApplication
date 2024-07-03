package com.example.mypokemonapplication.domain.repository

import com.example.mypokemonapplication.core.Result
import com.example.mypokemonapplication.domain.model.PokemonEntity

interface PokemonsRepository {

    suspend fun fetchAllPokemons(): Result<List<PokemonEntity>>
}