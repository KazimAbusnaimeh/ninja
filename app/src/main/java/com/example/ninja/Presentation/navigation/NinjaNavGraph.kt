package com.example.ninja.Presentation.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.ninja.Presentation.restaurantDetails.RestaurantDetailsRoute
import com.example.ninja.Presentation.restaurants.RestaurantsRoute

@Composable
fun NinjaNavGraph(navController: NavHostController) {
    val screenRoutes: List<BaseScreenRoute> = listOf(
        RestaurantsRoute(),
        RestaurantDetailsRoute()
    )

    NavHost(navController, startDestination = NavigationDestination.Restaurants.route,
        enterTransition = { slideInHorizontally { it } + fadeIn() },
        exitTransition = { slideOutHorizontally { -it } + fadeOut() },
        popEnterTransition = { slideInHorizontally { -it } + fadeIn() },
        popExitTransition = { slideOutHorizontally { it } + fadeOut() }
    ) {
        screenRoutes.forEach { route ->
            route.addRoute(this, navController)
        }
    }
}

