package com.example.mypokemonapplication.data.datasource

import com.example.mypokemonapplication.core.datasource.DataSource
import com.example.mypokemonapplication.core.network.ApiService
import com.example.mypokemonapplication.data.model.JsonPokemons
import javax.inject.Inject

class PokemonsDataSource @Inject constructor(
    private val apiService: ApiService
) : DataSource<Unit, JsonPokemons> {

    override suspend fun execute(param: Unit): JsonPokemons {
        return apiService.getAllPokemons().body() ?: throw Exception()
    }
}