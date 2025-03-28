package com.nebsan.recipeschallenge.domain.model

data class Recipe(
    val id: Int,
    val name: String,
    val instructions: List<String>
)
