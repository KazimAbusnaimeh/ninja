package com.example.ninja.Presentation.restaurants

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.ninja.data.Repository
import com.example.ninja.domain.models.Restaurant
import com.example.ninja.domain.models.RestaurantsCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RestaurantsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _restaurantsCategories = MutableStateFlow<List<RestaurantsCategory>?>(null)
    val restaurantsCategories = _restaurantsCategories.asStateFlow()

    private val _restaurants = MutableStateFlow<List<Restaurant>?>(null)
    val restaurants = _restaurants.asStateFlow()

    val selectedCategoryIndex = mutableStateOf(0)

    init {
        getRestaurantsCategories()
        getRestaurants()
    }

    fun onSelectedCategoryIndexChanged(index: Int) {
        selectedCategoryIndex.value = index
    }

    private fun getRestaurantsCategories() {
        _restaurantsCategories.value = repository.getRestaurantsCategories()
        if (_restaurantsCategories.value !== null)
            selectedCategoryIndex.value = _restaurantsCategories.value!!.first().id
    }

    private fun getRestaurants() {
        _restaurants.value = repository.getRestaurants()
    }
}