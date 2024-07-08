package com.example.mypokemonapplication.data.datasource

import com.example.mypokemonapplication.core.network.ApiService
import com.example.mypokemonapplication.data.mock.PokemonDetailsJsonResponseMock
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.given
import retrofit2.Response

@ExtendWith(MockitoExtension::class)
class PokemonDetailsDataSourceTest {

    @Mock
    lateinit var apiService: ApiService

    @InjectMocks
    lateinit var dataSource: PokemonDetailsDataSource

    @Test
    fun `execute - when response body is not null - then should return JsonDetailsPokemon`() = runTest {
        // Given
        given(apiService.fetchPokemonsByName("pokemonName")).willReturn(Response.success(PokemonDetailsJsonResponseMock.jsonDetailsPokemon))

        // When
        val result = dataSource.execute(param = "pokemonName")

        // Then
        assertThat(result).isEqualTo(PokemonDetailsJsonResponseMock.jsonDetailsPokemon)
    }

    @Test
    fun `execute - when response body is null - then should throw exception`() = runTest {
        // Given
        given(apiService.fetchPokemonsByName("pokemonName")).willReturn(Response.success(null))

        // Then
        assertThrows<Exception> {
            // When
            dataSource.execute(param = "pokemonName")
        }
    }
}