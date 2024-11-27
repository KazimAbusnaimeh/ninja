package com.example.ninja.Presentation.restaurantDetails

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.ninja.data.Repository
import com.example.ninja.domain.models.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RestaurantDetailsViewModel @Inject constructor(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _restaurant = MutableStateFlow<Restaurant?>(null)
    val restaurant = _restaurant.asStateFlow()

    val selectedMealTag = mutableStateOf(0)

    val args: RestaurantDetailsScreenArgs = RestaurantDetailsScreenArgs(savedStateHandle)

    init {
        getRestaurantById()
    }

    fun onMealTagChanged(index: Int) {
        selectedMealTag.value = index
    }

    private fun getRestaurantById() {
        _restaurant.value = repository.getRestaurantsById(args.id.toInt())
        val tags = restaurant.value?.tags
        if (!tags.isNullOrEmpty()) {
            selectedMealTag.value = tags.first().id
        }
    }
}