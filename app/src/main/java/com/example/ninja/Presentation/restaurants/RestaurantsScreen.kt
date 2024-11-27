package com.example.ninja.Presentation.restaurants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.ninja.Presentation.restaurantDetails.RestaurantDetailsRoute.Companion.navigateToRestaurantDetails
import com.example.ninja.core.components.HorizontalSelectRow
import com.example.ninja.core.components.RestaurantWidget
import com.example.ninja.core.components.SectionTitle
import com.example.ninja.core.theme.GrayEdge
import com.example.ninja.domain.models.Restaurant
import com.example.ninja.domain.models.RestaurantsCategory

@Composable
fun RestaurantsScreen(
    navController: NavHostController,
    viewModel: RestaurantsViewModel = hiltViewModel(),
) {
    val selectedCategoryIndex by viewModel.selectedCategoryIndex
    val restaurantsCategories by viewModel.restaurantsCategories.collectAsState()
    val restaurants by viewModel.restaurants.collectAsState()
    RestaurantsContent(
        restaurantsCategories,
        restaurants = restaurants,
        selectedCategoryIndex,
        onCategoryChanged = { newIndex -> viewModel.onSelectedCategoryIndexChanged(newIndex) },
        restaurantClicked = { navController.navigateToRestaurantDetails(it) }
    )
}

@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    RestaurantsContent(null, null, 0, {}, {})
}

@Composable
private fun RestaurantsContent(
    restaurantsCategories: List<RestaurantsCategory>?,
    restaurants: List<Restaurant>?,
    currentCategoryIndex: Int,
    onCategoryChanged: (Int) -> Unit,
    restaurantClicked: (String) -> Unit
) {
    LazyColumn(modifier = Modifier.padding(16.dp, 0.dp)) {
        item {
            SectionTitle(
                "Restaurants",
                modifier = Modifier.padding(0.dp, 16.dp, 0.dp, 8.dp)
            )
        }
        item {
            restaurantsCategories?.let {
                HorizontalSelectRow(
                    currentCategoryIndex,
                    it, onCategoryChanged
                )
            }
        }
        item {
            Spacer(Modifier.height(4.dp))
        }
        item {
            Column {
                restaurants?.let {
                    restaurants.forEach { restaurant ->
                        Spacer(modifier = Modifier.height(12.dp))
                        RestaurantWidget(
                            restaurant,
                            restaurantClicked = { restaurantClicked(restaurant.id.toString()) }
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(13.dp)
                                .padding(0.dp, 12.dp, 0.dp, 0.dp)
                                .background(GrayEdge)
                        )
                    }
                }
            }
        }
    }
}


