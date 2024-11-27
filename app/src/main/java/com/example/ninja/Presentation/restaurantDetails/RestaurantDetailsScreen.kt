package com.example.ninja.Presentation.restaurantDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ninja.R
import com.example.ninja.core.components.HorizontalSelectRow
import com.example.ninja.core.components.RestaurantWidget
import com.example.ninja.core.components.SectionTitle
import com.example.ninja.core.theme.GrayText
import com.example.ninja.domain.models.Meal
import com.example.ninja.domain.models.MealsSection
import com.example.ninja.domain.models.Restaurant

@Composable
fun RestaurantDetailsScreen(viewModel: RestaurantDetailsViewModel = hiltViewModel()) {
    val restaurant by viewModel.restaurant.collectAsState()
    val selectedMealTag by viewModel.selectedMealTag
    RestaurantDetailsContent(restaurant,
        selectedMealTag,
        onMealTagChanged = { newIndex -> viewModel.onMealTagChanged(newIndex) })
}

@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    RestaurantDetailsContent(null, 0, {})
}

@Composable
private fun RestaurantDetailsContent(
    restaurant: Restaurant?,
    selectedMealTag: Int,
    onMealTagChanged: (Int) -> Unit
) {
    LazyColumn(
        Modifier
            .fillMaxSize()
    ) {
        item {
            restaurant?.let {
                LayoutImage(restaurant.layoutImage)
            }
        }
        item {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .offset(y = -50.dp)
            ) {
                restaurant?.let {
                    RestaurantWidget(restaurant)

                    Spacer(Modifier.height(16.dp))

                    HorizontalSelectRow(
                        selectedMealTag,
                        restaurant.tags,
                    )
                    { id -> onMealTagChanged(id) }

                    restaurant.mealsSections.forEach { section ->
                        SectionItem(section)
                        Spacer(Modifier.height(32.dp))
                    }
                }
            }
        }

    }
}

@Composable
private fun SectionItem(section: MealsSection) {
    Column {
        SectionTitle(
            section.title,
            modifier = Modifier.padding(0.dp, 16.dp, 0.dp, 12.dp)
        )
        section.meals.forEachIndexed { index, meal ->
            MealItem(meal)
            if (index != section.meals.lastIndex) Spacer(Modifier.height(25.dp))
            else Spacer(Modifier.height(12.dp))
        }
    }
}

@Composable
private fun MealItem(meal: Meal) {
    Row(
        Modifier
            .height(96.dp)
            .fillMaxWidth()
    ) {
        if (meal.image.isNullOrBlank())
            Image(
                painter = painterResource(R.drawable.meal), null,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(96.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop,
            )
        Spacer(Modifier.width(8.dp))
        MealContent(meal)
    }
}

@Composable
private fun MealContent(meal: Meal) {
    Column(
        Modifier
            .fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(meal.name, fontSize = 16.sp, fontWeight = FontWeight(500))
        Text(
            meal.description,
            fontSize = 12.sp,
            fontWeight = FontWeight(450), color = GrayText
        )
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(meal.price, fontSize = 16.sp, fontWeight = FontWeight(500))
            Button(
                onClick = { },
                modifier = Modifier
                    .size(32.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    Color.White, Color.Black
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 4.dp
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "+",
                    fontSize = 28.sp,
                    fontWeight = FontWeight(400),
                    color = Color.Black,
                )
            }
        }
    }
}

@Composable
private fun LayoutImage(image: String?) {
    if (image == null) {
        Image(
            painter = painterResource(R.drawable.burger),
            null,
            modifier = Modifier
                .fillMaxWidth()
                .height(263.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun RestaurantWidget(restaurant: Restaurant) {
    Box(
        Modifier
            .shadow(2.dp, shape = RoundedCornerShape(8.dp))
    ) {
        Box(
            Modifier
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            RestaurantWidget(restaurant, 52, false) { }
        }
    }
}

