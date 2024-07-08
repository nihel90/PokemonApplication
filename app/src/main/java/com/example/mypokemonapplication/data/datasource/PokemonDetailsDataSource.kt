package com.example.mypokemonapplication.data.datasource

import com.example.mypokemonapplication.core.datasource.DataSource
import com.example.mypokemonapplication.core.network.ApiService
import com.example.mypokemonapplication.data.model.JsonDetailsPokemons
import javax.inject.Inject
import kotlin.jvm.Throws

class PokemonDetailsDataSource @Inject constructor(
    private val apiService: ApiService
) : DataSource<String, JsonDetailsPokemons> {

    @Throws(Exception::class)
    override suspend fun execute(param: String): JsonDetailsPokemons {
        return apiService.fetchPokemonsByName(name= param).body() ?: throw Exception()
    }
}