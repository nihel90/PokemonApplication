package com.example.mypokemonapplication.domain.interactor

import com.example.mypokemonapplication.domain.repository.PokemonDetailsRepository
import com.example.mypokemonapplication.domain.repository.PokemonsRepository
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.InjectMocks
import org.mockito.kotlin.then

@ExtendWith(MockitoExtension::class)
class PokemonsInteractorTest {

    @Mock
    lateinit var pokemonsRepository: PokemonsRepository

    @Mock
    lateinit var pokemonDetailsRepository: PokemonDetailsRepository

    @InjectMocks
    lateinit var interactor: PokemonsInteractor

    @Test
    fun `getAllPokemons `() = runTest {
        // When
        interactor.getAllPokemons()

        // Then
        then(pokemonsRepository).should().fetchAllPokemons()
    }

    @Test
    fun `getDetailsPokemon `() = runTest {
        // When
        interactor.getPokemonsDetails("pokemonName")

        // Then
        then(pokemonDetailsRepository).should().fetchPokemonByName("pokemonName")
    }
}