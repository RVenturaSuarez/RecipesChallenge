package com.nebsan.recipeschallenge.domain.usecase

import com.nebsan.recipeschallenge.domain.mapper.RecipesMapper.toDomain
import com.nebsan.recipeschallenge.domain.repository.RecipesRepository
import com.nebsan.recipeschallenge.utils.ResultRecipes
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(private val recipesRepository: RecipesRepository) {
    suspend fun getRecipes(): ResultRecipes {
        return try {
            ResultRecipes.Success(recipesRepository.getRecipes().toDomain())
        } catch (e: Exception) {
            ResultRecipes.Error
        }
    }

}