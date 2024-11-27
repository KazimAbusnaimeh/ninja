package com.example.ninja.Presentation.restaurants

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.ninja.Presentation.navigation.BaseScreenRoute
import com.example.ninja.Presentation.navigation.NavigationDestination
import com.example.ninja.core.theme.MainColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class RestaurantsRoute : BaseScreenRoute() {
    override fun addRoute(navGraphBuilder: NavGraphBuilder, navHostController: NavHostController) {
        navGraphBuilder.composable(NavigationDestination.Restaurants.route) {
            SetSystemBarColor()
            RestaurantsScreen(navHostController)
        }
    }

    @Composable
    override fun SetSystemBarColor() {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setStatusBarColor(
                color = MainColor,
                darkIcons = true
            )
        }
    }

    companion object {
        fun NavHostController.navigateToRestaurants() {
            navigate(NavigationDestination.Restaurants.route)
        }
    }
}


