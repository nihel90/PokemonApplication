package com.example.mypokemonapplication.core.network

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(ServiceCatalog.GET_ALL_POKEMON)
    suspend fun getAllPokemons(): Response<JsonPokemons>
}