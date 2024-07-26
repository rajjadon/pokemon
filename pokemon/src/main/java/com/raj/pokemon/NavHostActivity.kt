package com.raj.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.raj.common.baseClasses.BaseViewModel
import com.raj.common.extension.collectSharedFlowData
import com.raj.common.extension.showStringToast
import com.raj.pokemon.navigation.NavigationScreens
import com.raj.pokemon.ui.theme.PokemonTheme
import com.raj.presentation.home.HomeScreen
import com.raj.presentation.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavHostActivity : ComponentActivity() {

    private val baseViewModel: BaseViewModel by viewModels()
    private lateinit var navController : NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonTheme  {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    navController = rememberNavController()
                    NavigationGraph()
                }
            }
        }

        collectSharedFlowData(baseViewModel.pokemonAppError) {
            showStringToast(it.getNetworkErrorMessage())
        }
    }

    @Preview
    @Composable
    fun NavigationGraph() {
        NavHost(navController, startDestination = NavigationScreens.HomeScreen.route) {
            composable(NavigationScreens.HomeScreen.route) {
                val homeViewModel: HomeViewModel = hiltViewModel()
                homeViewModel.fetchPokemon()
                HomeScreen(homeViewModel)
            }
            composable(
                route = NavigationScreens.DetailsScreen.route + "/{name}",
                arguments = listOf(
                    navArgument("name") {
                        type = NavType.StringType
                        defaultValue = "Some Default"
                        nullable = true
                    }
                )
            ) { entry ->
                //DetailScreen(name = entry.arguments?.getString("name"))
            }
        }
    }
}