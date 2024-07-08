package com.example.mypokemonapplication.core.network

import com.example.mypokemonapplication.data.model.JsonDetailsPokemons
import com.example.mypokemonapplication.data.model.JsonPokemons
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET(ServiceCatalog.GET_ALL_POKEMONS)
    suspend fun fetchAllPokemons(): Response<JsonPokemons>

    @GET(ServiceCatalog.GET_POKEMON_BY_NAME)
    suspend fun fetchPokemonsByName(@Path("name") name: String): Response<JsonDetailsPokemons>
}