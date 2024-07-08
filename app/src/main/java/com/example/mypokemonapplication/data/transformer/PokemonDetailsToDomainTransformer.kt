package com.example.mypokemonapplication.data.transformer

import com.example.mypokemonapplication.data.model.JsonDetailsPokemons
import com.example.mypokemonapplication.domain.model.Abilities
import com.example.mypokemonapplication.domain.model.Ability
import com.example.mypokemonapplication.domain.model.PokemonDetailsEntity
import com.example.mypokemonapplication.domain.model.Sprites
import javax.inject.Inject

class PokemonDetailsToDomainTransformer @Inject constructor() {

    fun toDomain(jsonDetailsPokemons: JsonDetailsPokemons): PokemonDetailsEntity =
        PokemonDetailsEntity(
            id = jsonDetailsPokemons.id,
            name = jsonDetailsPokemons.name,
            height = jsonDetailsPokemons.height,
            url = jsonDetailsPokemons.url,
            abilities = jsonDetailsPokemons.abilities.map { jsonAbilities ->
                Abilities(
                    ability = Ability(
                        name = jsonAbilities.ability?.name,
                        url = jsonAbilities.ability?.url
                    ),
                    isHidden = jsonAbilities.isHidden,
                    slot = jsonAbilities.slot
                )
            },
            sprites = Sprites(frontDefault = jsonDetailsPokemons.sprites.frontDefault)
        )
}