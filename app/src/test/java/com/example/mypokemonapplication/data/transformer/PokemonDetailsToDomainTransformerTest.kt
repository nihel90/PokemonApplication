package com.example.mypokemonapplication.data.transformer

import com.example.mypokemonapplication.data.mock.PokemonDetailsJsonResponseMock
import com.example.mypokemonapplication.data.mock.PokemonDetailsMock
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class PokemonDetailsToDomainTransformerTest {

    @InjectMocks
    lateinit var transformer: PokemonDetailsToDomainTransformer

    @Test
    fun `toDomain - should return PokemonDetailsEntity`() {
        // When
        val result = transformer.toDomain(jsonDetailsPokemons = PokemonDetailsJsonResponseMock.jsonDetailsPokemon)

        // Then
        assertThat(result).isEqualTo(PokemonDetailsMock.pokemonDetails)
    }
}