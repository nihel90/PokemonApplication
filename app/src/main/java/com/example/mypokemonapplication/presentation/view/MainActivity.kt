package com.example.mypokemonapplication.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mypokemonapplication.data.datasource.PokemonDetailsDataSource
import com.example.mypokemonapplication.domain.interactor.PokemonsInteractor
import com.example.mypokemonapplication.presentation.viewmodel.PokemonsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var pokemonsViewModel: PokemonsViewModel

    @Inject
    lateinit var interactor: PokemonsInteractor

    @Inject
    lateinit var dataSource: PokemonDetailsDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pokemonsViewModel.getAllPokemons()
        setContent {
            MainScreen(viewModel = pokemonsViewModel)
        }
    }
}