package com.example.ninja.domain.models

data class MealsSection(
    val id: Int,
    val title: String,
    val meals: List<Meal>
)