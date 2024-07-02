package com.example.mypokemonapplication.data.model

import androidx.annotation.Keep
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@Keep
@JsonIgnoreProperties(ignoreUnknown = true)
data class JsonPokemons(
    @JsonProperty("count")
    val count: Int,
    @JsonProperty("results")
    val pokemons: List<JsonPokemon>
)

@Keep
@JsonIgnoreProperties(ignoreUnknown = true)
data class JsonPokemon(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("url")
    val url: String,
)
