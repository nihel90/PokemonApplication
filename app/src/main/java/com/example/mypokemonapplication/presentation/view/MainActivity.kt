package com.example.mypokemonapplication.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import com.example.mypokemonapplication.presentation.viewmodel.PokemonsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var pokemonsViewModel: PokemonsViewModel

    private lateinit var navController: NavHostController

    companion object {
        private const val POKEMON_ID = "pokemonId"
        private const val POKEMON_DETAILS_ROUTING_PARAM = "{pokemonId}"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pokemonsViewModel.getAllPokemons()
      /*  setContent {
            MainScreen(viewModel = pokemonsViewModel)
        }
       */

        setContent {
            navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = NavHostRouting.MAIN.route
            ) {
                composable(
                    route = NavHostRouting.MAIN.route) {
                    MainScreen(
                        viewModel = pokemonsViewModel,
                        onPokemonClick = ::navigateToPokemonDetails
                    )
                }
                composable(
                    route = NavHostRouting.DETAILS.route,
                    arguments = listOf(navArgument(POKEMON_ID) { type = NavType.StringType })
                ) { navBackStackEntry ->
                    val pokemonId = navBackStackEntry.arguments?.getString(POKEMON_ID)
                    PokemonDetailsScreen(
                    )
                }
            }

        }
    }

    private fun onBackClicked() {
        navController.popBackStack()
    }

    private fun navigateToPokemonDetails(pokemonId: String) {
        navController.navigate(
            NavHostRouting.DETAILS.route.replace(
                POKEMON_DETAILS_ROUTING_PARAM,
                pokemonId
            )
        )
    }

    enum class NavHostRouting(val route: String) {
        MAIN("main"),
        DETAILS("details/{pokemonId}")
    }
}