package com.example.mypokemonapplication.domain.model

data class PokemonDetailsEntity(
    val id: Int? = null,
    val name: String? = null,
    val height: Int? = null,
    val url: String? = null,
    val abilities: List<Abilities>? = null,
    val sprites: Sprites ? = null
)

data class Abilities(
    val ability: Ability? = null,
    val isHidden: Boolean? = null,
    val slot: Int? = null
)

data class Ability(
    val name: String? = null,
    val url: String? = null
)

data class Sprites(
    val frontDefault: String? = null
)