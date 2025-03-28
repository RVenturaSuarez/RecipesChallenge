package com.nebsan.recipeschallenge.domain.mapper

import com.nebsan.recipeschallenge.data.local.entities.RecipeEntity
import com.nebsan.recipeschallenge.data.remote.dto.RecipeDto
import com.nebsan.recipeschallenge.data.remote.dto.RecipesResponseDto
import com.nebsan.recipeschallenge.domain.mapper.RecipesMapper.toDomain
import com.nebsan.recipeschallenge.domain.mapper.RecipesMapper.toDto
import com.nebsan.recipeschallenge.domain.mapper.RecipesMapper.toEntity
import com.nebsan.recipeschallenge.domain.model.Recipe
import org.junit.Test
import org.junit.Assert.assertEquals

class RecipesMapperTest {

    @Test
    fun `recipesResponseDto is correctly mapper recipesResponse`() {
        // GIVEN
        val recipesResponseDto = RecipesResponseDto(
            recipes = listOf(RecipeDto(1, "Recipe 1", listOf("Instruction 1")))
        )

        // WHEN
        val recipesResponse = recipesResponseDto.toDomain()

        val expectedRecipe = Recipe(1, "Recipe 1", listOf("Instruction 1"))

        // THEN
        assertEquals(recipesResponseDto.recipes.size, recipesResponse.recipes.size)
        assertEquals(recipesResponse.recipes[0], expectedRecipe)
    }

    @Test
    fun `recipeDto is correctly mapper recipeEntity`() {
        // GIVEN
        val recipeDto = RecipeDto(1, "Recipe 1", listOf("Instruction 1"))

        // WHEN
        val recipeEntity = recipeDto.toEntity()
        val expectedRecipeEntity = RecipeEntity(1, "Recipe 1", listOf("Instruction 1"))

        // THEN
        assertEquals(recipeEntity, expectedRecipeEntity)
    }

    @Test
    fun `recipeEntity is correctly mapper recipeDto`() {
        // GIVEN
        val recipeEntity = RecipeEntity(1, "Recipe 1", listOf("Instruction 1"))

        // WHEN
        val recipeDto = recipeEntity.toDto()
        val expectedRecipeDto = RecipeDto(1, "Recipe 1", listOf("Instruction 1"))

        // THEN
        assertEquals(recipeDto, expectedRecipeDto)
    }

}