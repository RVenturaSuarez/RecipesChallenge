package com.nebsan.recipeschallenge.utils

import com.nebsan.recipeschallenge.domain.model.RecipesResponse

sealed class ResultRecipes {
    data object Loading : ResultRecipes()
    data class Success(val recipesResponse: RecipesResponse) : ResultRecipes()
    data object Error : ResultRecipes()
}