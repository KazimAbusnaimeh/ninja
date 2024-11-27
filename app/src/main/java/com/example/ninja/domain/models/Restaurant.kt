package com.example.ninja.domain.models

data class Restaurant(
    var id: Int,
    val logoImage: String? = null,
    val layoutImage: String? = null,
    val name: String,
    val isAdvertised: Boolean,
    val types: List<String>,
    val tags: List<Tag>,
    val deliveryTime: String,
    val deliveryDistance: String,
    val deliveryPrice: String,
    val isFreeDelivery: Boolean,
    val mealsSections: List<MealsSection>
)
