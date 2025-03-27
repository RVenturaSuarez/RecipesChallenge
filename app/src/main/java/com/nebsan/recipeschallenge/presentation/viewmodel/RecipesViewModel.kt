package com.nebsan.recipeschallenge.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nebsan.recipeschallenge.domain.model.Recipe
import com.nebsan.recipeschallenge.domain.model.RecipesResponse
import com.nebsan.recipeschallenge.domain.usecase.GetRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(private val getRecipesUseCase: GetRecipesUseCase) :
    ViewModel() {

    var recipes = mutableStateOf<RecipesResponse?>(null)
        private set

    var selectedRecipe = mutableStateOf<Recipe?>(null)
        private set

    init {
        getRecipes()
    }

    private fun getRecipes() {
        viewModelScope.launch(Dispatchers.IO) {
            val recipesResponse = getRecipesUseCase.getRecipes()
            recipes.value = recipesResponse
        }
    }

    fun setRecipe(recipe: Recipe) {
        selectedRecipe.value = recipe
    }

}