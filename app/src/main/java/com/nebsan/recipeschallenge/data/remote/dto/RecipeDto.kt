package com.nebsan.recipeschallenge.data.remote.dto

data class RecipeDto(
    val id: Int,
    val name: String,
    val instructions: List<String>
)
