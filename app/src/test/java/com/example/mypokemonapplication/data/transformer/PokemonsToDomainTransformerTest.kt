package com.example.mypokemonapplication.data.transformer

import com.example.mypokemonapplication.data.mock.AllPokemonsJsonResponseMock
import com.example.mypokemonapplication.data.mock.AllPokemonsMock
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class PokemonsToDomainTransformerTest {

    @InjectMocks
    lateinit var transformer: PokemonsToDomainTransformer

    @Test
    fun `toDomain - should return list of PokemonEntity`() {
        // When
        val result = transformer.toDomain(AllPokemonsJsonResponseMock.jsonPokemons)

        // Then
        assertThat(result).isEqualTo(AllPokemonsMock.pokemons)
    }
}