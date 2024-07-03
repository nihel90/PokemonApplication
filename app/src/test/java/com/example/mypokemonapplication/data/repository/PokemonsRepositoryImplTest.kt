package com.example.mypokemonapplication.data.repository

import com.example.mypokemonapplication.core.Result
import com.example.mypokemonapplication.data.datasource.PokemonsDataSource
import com.example.mypokemonapplication.data.mock.AllPokemonsJsonResponseMock
import com.example.mypokemonapplication.data.mock.AllpokemonsMock
import com.example.mypokemonapplication.data.transformer.PokemonsToDomainTransformer
import com.example.mypokemonapplication.domain.model.PokemonEntity
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class PokemonsRepositoryImplTest {

    @Mock
    private lateinit var dataSource: PokemonsDataSource

    @Mock
    private lateinit var transformer: PokemonsToDomainTransformer

    @InjectMocks
    private lateinit var repository: PokemonsRepositoryImpl

    @Test
    fun `fetchAllPokemons - when data source call is success - then should return Success with data`() =
        runTest {
            // Given
            given(dataSource.execute(param = Unit)).willReturn(AllPokemonsJsonResponseMock.jsonPokemons)
            given(transformer.toDomain(jsonPokemons = AllPokemonsJsonResponseMock.jsonPokemons)).willReturn(
                AllpokemonsMock.pokemons
            )

            // When
            val result = repository.fetchAllPokemons()

            // Then
            assertThat(result).isEqualTo(Result.Success(data = AllpokemonsMock.pokemons))
        }

    @Test
    fun `fetchAllPokemons - when data source call throws exception - then should return Failure`() =
        runTest {
            // Given
            given(dataSource.execute(param = Unit)).willThrow(Exception())

            // When
            val result = repository.fetchAllPokemons()

            // Then
            assertThat(result).isEqualTo(Result.Failure<List<PokemonEntity>>())
        }
}