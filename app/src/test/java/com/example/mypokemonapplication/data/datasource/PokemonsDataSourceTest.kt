package com.example.mypokemonapplication.data.datasource

import com.example.mypokemonapplication.core.network.ApiService
import com.example.mypokemonapplication.data.model.JsonPokemon
import com.example.mypokemonapplication.data.model.JsonPokemons
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.given
import retrofit2.Response
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@ExtendWith(MockitoExtension::class)
class PokemonsDataSourceTest {

    @Mock
    lateinit var apiService: ApiService

    @InjectMocks
    lateinit var dataSource: PokemonsDataSource

    private val response = JsonPokemons(
        count = 2,
        pokemons = listOf(
            JsonPokemon(name = "Bolbasaur", url = "heloo je suis Bolbasaur"),
            JsonPokemon(name = "Pikatchu", url = "heloo je suis Pikatchou"),
        )
    )

    @Test
    fun `execute - when response body is not null - then should return JsonPokemons`() = runTest {
        // Given
        given(apiService.getAllPokemons()).willReturn(Response.success(response))

        // When
        val result = dataSource.execute(param = Unit)

        // Then
        assertThat(result).isEqualTo(response)
    }

    @Test
    fun `execute - when response body is null - then should throw exception`() = runTest {
        // Given
        given(apiService.getAllPokemons()).willReturn(Response.success(null))

        // Then
        assertThrows<Exception> {
            // When
            dataSource.execute(param = Unit)
        }
    }
}