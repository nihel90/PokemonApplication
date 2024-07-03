package com.example.mypokemonapplication.data.transformer

import com.example.mypokemonapplication.data.model.JsonPokemons
import com.example.mypokemonapplication.domain.model.PokemonEntity
import javax.inject.Inject

class PokemonsToDomainTransformer @Inject constructor() {

    fun toDomain(jsonPokemons: JsonPokemons): List<PokemonEntity> =
        jsonPokemons.pokemons.map { jsonPokemon ->
            PokemonEntity(
                name = jsonPokemon.name,
                url = jsonPokemon.url
            )
        }
}