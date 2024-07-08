package com.example.mypokemonapplication.data.repository

import com.example.mypokemonapplication.core.Result
import com.example.mypokemonapplication.data.datasource.PokemonDetailsDataSource
import com.example.mypokemonapplication.data.mock.PokemonDetailsJsonResponseMock
import com.example.mypokemonapplication.data.mock.PokemonDetailsMock
import com.example.mypokemonapplication.data.transformer.PokemonDetailsToDomainTransformer
import com.example.mypokemonapplication.domain.model.PokemonDetailsEntity
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class PokemonDetailsRepositoryImplTest {

    @Mock
    private lateinit var dataSource: PokemonDetailsDataSource

    @Mock
    private lateinit var transformer: PokemonDetailsToDomainTransformer

    @InjectMocks
    private lateinit var repository: PokemonDetailsRepositoryImpl

    @Test
    fun `fetchPokemonDetails - when data source call is success - then should return Success with data`() =
        runTest {
            // Given
            given(dataSource.execute(param = "pokemonName")).willReturn(PokemonDetailsJsonResponseMock.jsonDetailsPokemon)
            given(transformer.toDomain(jsonDetailsPokemons = PokemonDetailsJsonResponseMock.jsonDetailsPokemon)).willReturn(
                PokemonDetailsMock.pokemonDetails
            )

            // When
            val result = repository.fetchPokemonByName("pokemonName")

            // Then
            assertThat(result).isEqualTo(Result.Success(data = PokemonDetailsMock.pokemonDetails))
        }

    @Test
    fun `fetchPokemonDetails - when data source call throws exception - then should return Failure`() =
        runTest {
            // Given
            given(dataSource.execute(param = "pokemonName")).willThrow(Exception())

            // When
            val result = repository.fetchPokemonByName("pokemonName")

            // Then
            assertThat(result).isEqualTo(Result.Failure<List<PokemonDetailsEntity>>())
        }
}