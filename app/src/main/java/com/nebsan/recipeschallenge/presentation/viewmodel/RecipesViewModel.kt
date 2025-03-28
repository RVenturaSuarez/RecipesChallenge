package com.nebsan.recipeschallenge.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nebsan.recipeschallenge.domain.model.Recipe
import com.nebsan.recipeschallenge.domain.usecase.GetRecipesUseCase
import com.nebsan.recipeschallenge.utils.ResultRecipes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(private val getRecipesUseCase: GetRecipesUseCase) :
    ViewModel() {

    var resultRecipes = MutableStateFlow<ResultRecipes>(ResultRecipes.Loading)
        private set

    var selectedRecipe = mutableStateOf<Recipe?>(null)
        private set

    init {
        getRecipes()
    }

    private fun getRecipes() {
        viewModelScope.launch(Dispatchers.IO) {
            resultRecipes.value = ResultRecipes.Loading
            delay(1000L) // For user feedback if mobile is airplane mode, no insta result error
            resultRecipes.value = getRecipesUseCase.getRecipes()
        }
    }

    fun reloadData() {
        getRecipes()
    }

    fun setRecipe(recipe: Recipe) {
        selectedRecipe.value = recipe
    }

}