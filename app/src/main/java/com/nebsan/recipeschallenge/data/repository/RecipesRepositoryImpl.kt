package com.nebsan.recipeschallenge.data.repository

import com.nebsan.recipeschallenge.data.local.dao.RecipeDao
import com.nebsan.recipeschallenge.data.remote.RecipesApi
import com.nebsan.recipeschallenge.data.remote.dto.RecipesResponseDto
import com.nebsan.recipeschallenge.domain.mapper.RecipesMapper.toDto
import com.nebsan.recipeschallenge.domain.mapper.RecipesMapper.toEntity
import com.nebsan.recipeschallenge.domain.repository.RecipesRepository
import javax.inject.Inject

class RecipesRepositoryImpl @Inject constructor(
    private val recipeDao: RecipeDao, private val recipesApi: RecipesApi,
) : RecipesRepository {

    override suspend fun getRecipes(): RecipesResponseDto {
        val localRecipes = recipeDao.getAllRecipes()
        if (localRecipes.isNotEmpty()) {
            return RecipesResponseDto(localRecipes.map { recipeEntity -> recipeEntity.toDto() })
        } else {
            val recipesApi = recipesApi.getRecipes()
            recipeDao.insertRecipes(recipesApi.recipes.map { recipeDto -> recipeDto.toEntity() })
            return recipesApi
        }
    }
}