package com.nebsan.recipeschallenge.data.repository

import com.nebsan.recipeschallenge.data.remote.RecipesApi
import com.nebsan.recipeschallenge.data.remote.dto.RecipesResponseDto
import com.nebsan.recipeschallenge.domain.repository.RecipesRepository
import javax.inject.Inject

class RecipesRepositoryImpl @Inject constructor(private val recipesApi: RecipesApi) :
    RecipesRepository {

    override suspend fun getRecipes(): RecipesResponseDto {
        return recipesApi.getRecipes()
    }
}