package com.example.ninja.domain.models

data class RestaurantsCategory(
    override val id: Int,
    override val text: String
) : Tag(id, text)
