package com.nebsan.recipeschallenge.domain.usecase

import com.nebsan.recipeschallenge.domain.mapper.RecipesMapper.toDomain
import com.nebsan.recipeschallenge.domain.model.RecipesResponse
import com.nebsan.recipeschallenge.domain.repository.RecipesRepository
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(private val recipesRepository: RecipesRepository) {
    suspend fun getRecipes(): RecipesResponse = recipesRepository.getRecipes().toDomain()
}