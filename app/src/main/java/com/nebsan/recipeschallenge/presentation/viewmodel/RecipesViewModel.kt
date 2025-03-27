package com.nebsan.recipeschallenge.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nebsan.recipeschallenge.domain.usecase.GetRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(private val getRecipesUseCase: GetRecipesUseCase) :
    ViewModel() {

    init {
        viewModelScope.launch {
            val recipes = getRecipesUseCase.getRecipes()
            Log.d("NebsanDev", recipes.toString())
        }
    }

}