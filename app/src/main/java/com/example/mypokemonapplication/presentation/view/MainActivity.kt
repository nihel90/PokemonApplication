package com.example.mypokemonapplication.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.mypokemonapplication.presentation.state.PokemonsUiState
import com.example.mypokemonapplication.presentation.viewmodel.PokemonsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModel: PokemonsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{MainScreen()}

        viewModel.getAllPokemons()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.pokemonsUiState.collect { list ->
                    when (list) {
                        is PokemonsUiState.Idle -> println("idle")
                        is PokemonsUiState.Loading -> println("loading")
                        is PokemonsUiState.Ready -> println(
                            println("ready : here pokemon list ${list.pokemons}")
                        )
                        is PokemonsUiState.Error -> println("Error")
                    }
                }
            }
        }
    }
}