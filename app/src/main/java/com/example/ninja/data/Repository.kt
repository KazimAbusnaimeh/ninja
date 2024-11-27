package com.example.ninja.data

import com.example.ninja.domain.models.Restaurant
import com.example.ninja.domain.models.RestaurantsCategory
import javax.inject.Inject

class Repository @Inject constructor() {
    val restaurantsList = mutableListOf<Restaurant>()

    init {
        ((1..10).forEach { index ->
            DataSource.RESTAURANT.id = index
            restaurantsList.add(DataSource.RESTAURANT)
        })
    }

    fun getRestaurantsCategories(): List<RestaurantsCategory> {
        return DataSource.RESTAURANT_CATEGORIES
    }

    fun getRestaurants(): List<Restaurant> {
        return restaurantsList
    }

    fun getRestaurantsById(id: Int): Restaurant? {
        return restaurantsList.find { it.id == id }
    }
}