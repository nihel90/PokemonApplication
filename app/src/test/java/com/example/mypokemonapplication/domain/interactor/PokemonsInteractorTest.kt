package com.example.mypokemonapplication.domain.interactor

import com.example.mypokemonapplication.core.Result
import com.example.mypokemonapplication.data.mock.AllpokemonsMock
import com.example.mypokemonapplication.presentation.state.PokemonsUiState
import com.example.mypokemonapplication.presentation.viewmodel.PokemonsViewModel
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.given
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

@OptIn(ExperimentalCoroutinesApi::class)
@ExtendWith(MockitoExtension::class)
class PokemonsViewModelTest {

    @Mock
    lateinit var pokemonsInteractor: PokemonsInteractor

    private lateinit var pokemonsViewModel: PokemonsViewModel

    private val scheduler: TestCoroutineScheduler = TestCoroutineScheduler()

    private val testDispatcher: TestDispatcher = StandardTestDispatcher(scheduler)

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        pokemonsViewModel = PokemonsViewModel(
            interactor = pokemonsInteractor,
            dispatcher = testDispatcher
        )
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getAllPokemons - when Result is Success - then should update PokemonsUiState`() =
        runTest {
            // Given
            given(pokemonsInteractor.getAllPokemons()).willReturn(Result.Success(data = AllpokemonsMock.pokemons))

            // When
            pokemonsViewModel.getAllLeagues()

            // Then
            scheduler.advanceUntilIdle()
            assertThat(pokemonsViewModel.pokemonsUiState.value).isEqualTo(
                PokemonsUiState.Ready(
                    pokemons = listOf(
                        "Bolbasaur",
                        "Pikatchu",
                        "Bolbasaur",
                        "Pikatchu"
                    )
                )
            )
        }

    @Test
    fun `getAllPokemons - when Result is Failure - then should update PokemonsUiState`() =
        runTest {
            // Given
            given(pokemonsInteractor.getAllPokemons()).willReturn(Result.Failure())

            // When
            pokemonsViewModel.getAllLeagues()

            // Then
            scheduler.advanceUntilIdle()
            assertThat(pokemonsViewModel.pokemonsUiState.value).isEqualTo(
                PokemonsUiState.Error
            )
        }
}