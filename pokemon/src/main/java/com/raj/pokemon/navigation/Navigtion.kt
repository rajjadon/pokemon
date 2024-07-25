package com.raj.pokemon.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.raj.common.qualifiers.AppScreenEnum
import com.raj.pokemon.R

sealed class NavigationScreens(
    val route: String, @StringRes val resourceId: Int, val icon: ImageVector
) {
    data object HomeScreen :
        NavigationScreens(
            route = AppScreenEnum.POKEMON_LIST_SCREEN.route,
            resourceId = R.string.pokemon_list,
            icon = Icons.Filled.Home
        )

    data object DetailsScreen :
        NavigationScreens(
            route = AppScreenEnum.POKEMON_DETAILS_SCREEN.route,
            resourceId = R.string.pokemon_details,
            icon = Icons.Filled.Favorite
        )

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}