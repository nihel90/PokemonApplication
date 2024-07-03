package com.example.mypokemonapplication.data.transformer

import com.example.mypokemonapplication.data.mock.AllPokemonsJsonResponseMock
import com.example.mypokemonapplication.domain.model.PokemonEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class PokemonsToDomainTransformerTest {

    @InjectMocks
    lateinit var transformer: PokemonsToDomainTransformer

    private val domain = listOf(
        PokemonEntity(
            name = "Bolbasaur",
            url = "heloo je suis Bolbasaur"
        ),
        PokemonEntity(
            name = "Pikatchu",
            url = "heloo je suis Pikatchou"
        ),
        PokemonEntity(
            name = "Bolbasaur",
            url = "heloo je suis Bolbasaur"
        ),
        PokemonEntity(
            name = "Pikatchu",
            url = "heloo je suis Pikatchou"
        ),
    )

    @Test
    fun `toDomain - should return list of PokemonEntity`() {
        // When
        val result = transformer.toDomain(AllPokemonsJsonResponseMock.jsonPokemons)

        // Then
        assertThat(result).isEqualTo(domain)
    }
}