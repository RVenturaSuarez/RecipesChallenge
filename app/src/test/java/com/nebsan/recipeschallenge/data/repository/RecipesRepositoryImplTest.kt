package com.nebsan.recipeschallenge.data.repository

import com.nebsan.recipeschallenge.data.local.dao.RecipeDao
import com.nebsan.recipeschallenge.data.local.entities.RecipeEntity
import com.nebsan.recipeschallenge.data.remote.RecipesApi
import com.nebsan.recipeschallenge.data.remote.dto.RecipeDto
import com.nebsan.recipeschallenge.data.remote.dto.RecipesResponseDto
import com.nebsan.recipeschallenge.domain.repository.RecipesRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class RecipesRepositoryImplTest {

    private lateinit var repository: RecipesRepository
    private lateinit var mockRecipeDao: RecipeDao
    private lateinit var mockRecipesApi: RecipesApi

    @Before
    fun setup() {
        mockRecipeDao = mock(RecipeDao::class.java)
        mockRecipesApi = mock(RecipesApi::class.java)
        repository = RecipesRepositoryImpl(mockRecipeDao, mockRecipesApi)
    }

    @Test
    fun `getRecipes returns data from local DB`() = runTest {
        // WHEN
        val localRecipes = listOf(RecipeEntity(1, "Recipe 1", listOf("Instruction 1")))

        // WHEN
        `when`(mockRecipeDao.getAllRecipes()).thenReturn(localRecipes)
        val result = repository.getRecipes()

        val expectedRecipesResponseDto = RecipesResponseDto(
            recipes = listOf(RecipeDto(1, "Recipe 1", listOf("Instruction 1")))
        )

        // THEN
        assertEquals(result.recipes.size, 1)
        assertEquals(result, expectedRecipesResponseDto)
    }

    @Test
    fun `getRecipes returns data from local API`() = runTest {
        // WHEN
        val localRecipes = emptyList<RecipeEntity>()
        val apiRecipes = RecipesResponseDto(
            recipes = listOf(RecipeDto(1, "Recipe 1", listOf("Instruction 1")))
        )

        // WHEN
        `when`(mockRecipeDao.getAllRecipes()).thenReturn(localRecipes)
        `when`(mockRecipesApi.getRecipes()).thenReturn(apiRecipes)
        val result = repository.getRecipes()

        val expectedRecipesResponseDto = RecipesResponseDto(
            recipes = listOf(RecipeDto(1, "Recipe 1", listOf("Instruction 1")))
        )

        // THEN
        assertEquals(result.recipes.size, 1)
        assertEquals(result, expectedRecipesResponseDto)
    }

}
