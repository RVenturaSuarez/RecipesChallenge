package com.nebsan.recipeschallenge.presentation.viewmodel

import com.nebsan.recipeschallenge.domain.model.Recipe
import com.nebsan.recipeschallenge.domain.model.RecipesResponse
import com.nebsan.recipeschallenge.domain.usecase.GetRecipesUseCase
import com.nebsan.recipeschallenge.utils.ResultRecipes
import io.mockk.every
import io.mockk.mockkStatic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@OptIn(ExperimentalCoroutinesApi::class)
class RecipesViewModelTest {

    private lateinit var getRecipesUseCase: GetRecipesUseCase
    private lateinit var viewModel: RecipesViewModel

    @Before
    fun setup() {
        getRecipesUseCase = mock(GetRecipesUseCase::class.java) // MOCK REAL
        viewModel = RecipesViewModel(getRecipesUseCase)
    }

    @get:Rule
    val dispatcherRule = TestViewModelScopeRule()


    @ExperimentalCoroutinesApi
    class TestViewModelScopeRule(private val dispatcher: TestDispatcher = StandardTestDispatcher()) :
        TestWatcher() {

        override fun starting(description: Description?) {
            super.starting(description)
            Dispatchers.setMain(dispatcher)
        }

        override fun finished(description: Description?) {
            super.finished(description)
            Dispatchers.resetMain()
        }
    }


    @Test
    fun `getRecipes return Success and update resultRecipes state correctly`() = runTest {
        // GIVEN
        val recipesResponse =
            RecipesResponse(recipes = listOf(Recipe(1, "Recipe 111", listOf("Instruction 1"))))
        val resultRecipes = ResultRecipes.Success(recipesResponse = recipesResponse)

        `when`(getRecipesUseCase.getRecipes()).thenReturn(resultRecipes)

        // WHEN
        mockkStatic(Dispatchers::class)
        val dispatcher = StandardTestDispatcher()
        every { Dispatchers.IO } returns dispatcher

        viewModel.reloadData()
        advanceUntilIdle()

        // THEN
        assertTrue(viewModel.resultRecipes.value is ResultRecipes.Success)
    }


    @Test
    fun `getRecipes return Error and update resultRecipes state correctly`() = runTest {
        // GIVEN
        val resultRecipes = ResultRecipes.Error

        // WHEN
        `when`(getRecipesUseCase.getRecipes()).thenReturn(resultRecipes)

        mockkStatic(Dispatchers::class)
        val dispatcher = StandardTestDispatcher()
        every { Dispatchers.IO } returns dispatcher

        viewModel.reloadData()
        advanceUntilIdle()

        // THEN
        assertTrue(viewModel.resultRecipes.value is ResultRecipes.Error)
    }

    @Test
    fun `setRecipe update selectedRecipe correctly`() = runTest {
        // GIVEN
        val recipe = Recipe(1, "Recipe 111", listOf("Instruction 1"))

        // WHEN
        viewModel.setRecipe(recipe)

        // THEN
        assertEquals(recipe, viewModel.selectedRecipe.value)
    }


}