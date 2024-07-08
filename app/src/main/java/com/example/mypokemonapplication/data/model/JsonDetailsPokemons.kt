package com.example.mypokemonapplication.data.model

import androidx.annotation.Keep
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@Keep
@JsonIgnoreProperties(ignoreUnknown = true)
data class JsonDetailsPokemons(
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("height")
    val height: Int,
    @JsonProperty("url")
    val url: String?,
    @JsonProperty("abilities")
    val abilities: List<JsonAbilities>,
    @JsonProperty("sprites")
    val sprites: JsonSprites
)

@Keep
@JsonIgnoreProperties(ignoreUnknown = true)
data class JsonAbilities(
    @JsonProperty("ability")
    var ability: JsonAbility? = null,
    @JsonProperty("is_hidden")
    var isHidden: Boolean? = null,
    @JsonProperty("slot")
    var slot: Int? = null
)

@Keep
@JsonIgnoreProperties(ignoreUnknown = true)
data class JsonAbility(
    @JsonProperty("name")
    var name: String? = null,
    @JsonProperty("url")
    var url: String? = null
)

@Keep
@JsonIgnoreProperties(ignoreUnknown = true)
data class JsonSprites(
    @JsonProperty("front_default")
    var frontDefault: String? = null
)