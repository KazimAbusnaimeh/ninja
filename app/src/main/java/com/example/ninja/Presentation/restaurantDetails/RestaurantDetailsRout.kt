package com.example.ninja.Presentation.restaurantDetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.ninja.Presentation.navigation.BaseScreenRoute
import com.example.ninja.Presentation.navigation.NavigationDestination
import com.example.ninja.core.theme.MainColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class RestaurantDetailsRoute : BaseScreenRoute() {

    override fun addRoute(navGraphBuilder: NavGraphBuilder, navHostController: NavHostController) {
        navGraphBuilder.composable(
            route = NavigationDestination.RestaurantsDetails(RestaurantDetailsScreenArgs.ID_ARG).route,
            arguments = listOf(
                navArgument(RestaurantDetailsScreenArgs.ID_ARG) { type = NavType.StringType }
            )
        ) {
            SetSystemBarColor()
            RestaurantDetailsScreen()
        }
    }

    @Composable
    override fun SetSystemBarColor() {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setStatusBarColor(
                color = MainColor,
                darkIcons = false
            )
        }
    }

    companion object {
        fun NavController.navigateToRestaurantDetails(id: String) {
            navigate(NavigationDestination.RestaurantsDetails(id).createRoute())
        }
    }
}


class RestaurantDetailsScreenArgs(savedStateHandle: SavedStateHandle) {
    val id: String = checkNotNull(savedStateHandle[ID_ARG])

    companion object {
        const val ID_ARG = "id"
    }
}