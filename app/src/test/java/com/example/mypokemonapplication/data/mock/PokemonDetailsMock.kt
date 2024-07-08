package com.example.mypokemonapplication.data.mock

import com.example.mypokemonapplication.domain.model.Abilities
import com.example.mypokemonapplication.domain.model.Ability
import com.example.mypokemonapplication.domain.model.PokemonDetailsEntity
import com.example.mypokemonapplication.domain.model.Sprites

object PokemonDetailsMock {

    val pokemonDetails: PokemonDetailsEntity = PokemonDetailsEntity(
        id = 1,
        name = "bulbasaur",
        height = 36,
        url = "https://bulbasaur.com",
        abilities = listOf(
            Abilities(
                ability = Ability(
                    name = "bulbasaur",
                    url = "https://bulbasaur.com"
                ),
                isHidden = true,
                slot = null
            )
        ),
        sprites = Sprites(
            frontDefault = "https://bulbasaur.png"
        )
    )

}