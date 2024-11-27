package com.example.ninja.Presentation.navigation

sealed class NavigationDestination(val route: String) {

    object Restaurants : NavigationDestination(RESTAURANTS_SCREEN)

    data class RestaurantsDetails(val id: String) :
        NavigationDestination("$RESTAURANTS_DETAILS_SCREEN/{id}") {
        fun createRoute(): String {
            return "$RESTAURANTS_DETAILS_SCREEN/$id"
        }
    }

    companion object AppDestinations {
        private const val RESTAURANTS_SCREEN = "restaurantScreen"
        private const val RESTAURANTS_DETAILS_SCREEN = "restaurantDetailsScreen"
    }

}
