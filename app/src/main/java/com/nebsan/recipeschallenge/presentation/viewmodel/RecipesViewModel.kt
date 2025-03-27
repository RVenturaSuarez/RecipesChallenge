package com.nebsan.recipeschallenge.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nebsan.recipeschallenge.data.remote.RecipesApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(private val recipesApi: RecipesApi) : ViewModel() {

    init {
        viewModelScope.launch {
            val recipes = recipesApi.getRecipes()
            Log.d("NebsanDev", recipes.toString())
        }
    }

}