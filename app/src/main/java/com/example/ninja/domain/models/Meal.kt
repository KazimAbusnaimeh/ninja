package com.example.ninja.domain.models

data class Meal(
    val id: Int,
    val image: String? = null,
    val name: String,
    val description: String,
    val price: String
)
