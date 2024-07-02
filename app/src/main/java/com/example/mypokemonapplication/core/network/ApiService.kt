package com.example.mypokemonapplication.core.network

import com.example.mypokemonapplication.data.model.JsonPokemons
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(ServiceCatalog.GET_ALL_POKEMON)
    suspend fun getAllPokemons(): Response<JsonPokemons>
}