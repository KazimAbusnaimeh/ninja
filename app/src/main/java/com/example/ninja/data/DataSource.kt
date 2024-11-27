package com.example.ninja.data

import com.example.ninja.domain.models.Meal
import com.example.ninja.domain.models.MealsSection
import com.example.ninja.domain.models.Restaurant
import com.example.ninja.domain.models.RestaurantsCategory
import com.example.ninja.domain.models.Tag

class DataSource {
    companion object {
        val RESTAURANT_CATEGORIES = listOf(
            RestaurantsCategory(1, "All"),
            RestaurantsCategory(2, "Shawarma"),
            RestaurantsCategory(3, "Falafel"),
            RestaurantsCategory(4, "Burger"),
            RestaurantsCategory(5, "Pizza"),
            RestaurantsCategory(6, "Sushi"),
            RestaurantsCategory(7, "Pasta"),
            RestaurantsCategory(8, "BBQ"),
            RestaurantsCategory(9, "Seafood"),
        )
        val RESTAURANT = Restaurant(
            id = 1,
            name = "The Great Eatery",
            isAdvertised = true,
            types = listOf("Fast Food", "Beverages", "Desserts"),
            tags = listOf(
                Tag(1, "Boxes"),
                Tag(2, "Beef Burger"),
                Tag(3, "Smoked Burger"),
                Tag(4, "Stake"),
                Tag(5, "Fish"),
                Tag(6, "Desert"),
            ),
            deliveryTime = "20 - 30 min",
            deliveryDistance = "1.5 km",
            deliveryPrice = "SAR 10.0",
            isFreeDelivery = false,
            mealsSections = listOf(
                MealsSection(
                    id = 1,
                    title = "Appetizers",
                    meals = listOf(
                        Meal(
                            id = 1,
                            name = "Spring Rolls",
                            description = "Crispy rolls filled with vegetables.",
                            price = "SAR 15.0"
                        ),
                        Meal(
                            id = 2,
                            name = "Garlic Bread",
                            description = "Freshly baked bread with garlic and butter.",
                            price = "SAR 12.0"
                        ),
                        Meal(
                            id = 3,
                            name = "Chicken Wings",
                            description = "Spicy wings with a tangy sauce.",
                            price = "SAR 20.0"
                        )
                    )
                ),
                MealsSection(
                    id = 2,
                    title = "Main Courses",
                    meals = listOf(
                        Meal(
                            id = 4,
                            name = "Grilled Chicken",
                            description = "Served with mashed potatoes and vegetables.",
                            price = "SAR 50.0"
                        ),
                        Meal(
                            id = 5,
                            name = "Beef Burger",
                            description = "Juicy beef patty with cheese and lettuce.",
                            price = "SAR 35.0"
                        ),
                        Meal(
                            id = 6,
                            name = "Vegetarian Pasta",
                            description = "Pasta in a rich tomato and basil sauce.",
                            price = "SAR 30.0"
                        )
                    )
                ),
                MealsSection(
                    id = 3,
                    title = "Desserts",
                    meals = listOf(
                        Meal(
                            id = 7,
                            name = "Chocolate Cake",
                            description = "Moist cake with chocolate frosting.",
                            price = "SAR 25.0"
                        ),
                        Meal(
                            id = 8,
                            name = "Ice Cream Sundae",
                            description = "Vanilla ice cream topped with chocolate sauce.",
                            price = "SAR 18.0"
                        ),
                        Meal(
                            id = 9,
                            name = "Fruit Salad",
                            description = "A mix of fresh seasonal fruits.",
                            price = "SAR 15.0"
                        )
                    )
                )
            )
        )

    }
}