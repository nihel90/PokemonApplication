package com.example.mypokemonapplication.data.mock

import com.example.mypokemonapplication.data.model.JsonPokemon
import com.example.mypokemonapplication.data.model.JsonPokemons

object AllPokemonsJsonResponseMock {

    val jsonPokemons = JsonPokemons(
        count = 2,
        pokemons = listOf(
            JsonPokemon(name = "Bolbasaur", url = "heloo je suis Bolbasaur"),
            JsonPokemon(name = "Pikatchu", url = "heloo je suis Pikatchou"),
            JsonPokemon(name = "Bolbasaur", url = "heloo je suis Bolbasaur"),
            JsonPokemon(name = "Pikatchu", url = "heloo je suis Pikatchou"),
        )
    )
}