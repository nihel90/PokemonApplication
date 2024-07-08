package com.example.mypokemonapplication.data.mock

import com.example.mypokemonapplication.data.model.JsonAbilities
import com.example.mypokemonapplication.data.model.JsonAbility
import com.example.mypokemonapplication.data.model.JsonDetailsPokemons
import com.example.mypokemonapplication.data.model.JsonSprites

object PokemonDetailsJsonResponseMock {
    val jsonDetailsPokemon: JsonDetailsPokemons = JsonDetailsPokemons(
        id = 1,
        name = "bulbasaur",
        height = 36,
        url = "https://bulbasaur.com",
        abilities = listOf(
            JsonAbilities(
                ability = JsonAbility(
                    name = "bulbasaur",
                    url = "https://bulbasaur.com"
                ),
                isHidden = true,
                slot = null
            )
        ),
        sprites = JsonSprites(
            frontDefault = "https://bulbasaur.png"
        )
    )
}