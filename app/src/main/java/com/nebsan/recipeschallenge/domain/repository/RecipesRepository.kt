package com.nebsan.recipeschallenge.domain.repository

import com.nebsan.recipeschallenge.data.remote.dto.RecipesResponseDto

interface RecipesRepository {
    suspend fun getRecipes(): RecipesResponseDto
}