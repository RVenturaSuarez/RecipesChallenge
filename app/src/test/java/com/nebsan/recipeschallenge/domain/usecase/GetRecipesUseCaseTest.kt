package com.nebsan.recipeschallenge.domain.usecase

import com.nebsan.recipeschallenge.data.local.dao.RecipeDao
import com.nebsan.recipeschallenge.data.local.entities.RecipeEntity
import com.nebsan.recipeschallenge.data.remote.RecipesApi
import com.nebsan.recipeschallenge.data.repository.RecipesRepositoryImpl
import com.nebsan.recipeschallenge.domain.repository.RecipesRepository
import com.nebsan.recipeschallenge.utils.ResultRecipes
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class GetRecipesUseCaseTest {

    private lateinit var getRecipesUseCase: GetRecipesUseCase
    private lateinit var repository: RecipesRepository
    private lateinit var mockRecipeDao: RecipeDao
    private lateinit var mockRecipesApi: RecipesApi

    @Before
    fun setup() {
        mockRecipeDao = mock(RecipeDao::class.java)
        mockRecipesApi = mock(RecipesApi::class.java)
        repository = RecipesRepositoryImpl(mockRecipeDao, mockRecipesApi)
        getRecipesUseCase = GetRecipesUseCase(repository)
    }

    @Test
    fun `getRecipes returns resultRecipes Success`() = runTest {
        // GIVEN
        val localRecipes: List<RecipeEntity> =
            listOf(RecipeEntity(1, "Recipe 1", listOf("Instruction 1")))

        // WHEN
        `when`(mockRecipeDao.getAllRecipes()).thenReturn(localRecipes)
        val result = getRecipesUseCase.getRecipes()

        // THEN
        assertTrue(result is ResultRecipes.Success)
    }


    @Test
    fun `getRecipes returns resultRecipes Error when exception is thrown`() = runTest {
        // WHEN
        `when`(getRecipesUseCase.getRecipes()).thenThrow(RuntimeException("Test error"))
        val result = getRecipesUseCase.getRecipes()

        // THEN
        assertTrue(result is ResultRecipes.Error)
    }


}