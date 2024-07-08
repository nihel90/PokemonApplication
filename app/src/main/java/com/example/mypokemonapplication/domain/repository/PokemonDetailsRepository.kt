package com.example.mypokemonapplication.domain.repository

import com.example.mypokemonapplication.core.Result
import com.example.mypokemonapplication.domain.model.PokemonDetailsEntity

interface PokemonDetailsRepository {

    suspend fun fetchPokemonByName(name: String): Result<PokemonDetailsEntity>
}