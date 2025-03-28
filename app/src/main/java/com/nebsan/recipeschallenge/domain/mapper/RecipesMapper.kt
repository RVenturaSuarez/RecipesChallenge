package com.nebsan.recipeschallenge.domain.mapper

import com.nebsan.recipeschallenge.data.local.entities.RecipeEntity
import com.nebsan.recipeschallenge.data.remote.dto.RecipeDto
import com.nebsan.recipeschallenge.data.remote.dto.RecipesResponseDto
import com.nebsan.recipeschallenge.domain.model.Recipe
import com.nebsan.recipeschallenge.domain.model.RecipesResponse

object RecipesMapper {

    fun RecipesResponseDto.toDomain(): RecipesResponse {
        return RecipesResponse(
            recipes = recipes.map { recipeDto -> recipeDto.toDomain() }
        )
    }

    private fun RecipeDto.toDomain(): Recipe {
        return Recipe(id = id, name = name, instructions = instructions)
    }


    fun RecipeDto.toEntity(): RecipeEntity {
        return RecipeEntity(id = id, name = name, instructions = instructions)
    }

    fun RecipeEntity.toDto(): RecipeDto {
        return RecipeDto(id = id, name = name, instructions = instructions)
    }
}