package com.nebsan.recipeschallenge.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nebsan.recipeschallenge.presentation.ui.components.RecipeInstructionsDialog
import com.nebsan.recipeschallenge.presentation.ui.components.RecipesList
import com.nebsan.recipeschallenge.presentation.ui.components.TopAppBarRecipes
import com.nebsan.recipeschallenge.presentation.viewmodel.RecipesViewModel

@Composable
fun RecipesScreen(recipesViewModel: RecipesViewModel = hiltViewModel()) {

    val recipesResponse = recipesViewModel.recipes.value
    val selectedRecipe = recipesViewModel.selectedRecipe.value

    var isInstructionsDialogVisible by rememberSaveable { mutableStateOf(false) }


    if (isInstructionsDialogVisible && selectedRecipe != null) {
        RecipeInstructionsDialog(
            selectedRecipe = selectedRecipe,
            onDismissRequest = { isInstructionsDialogVisible = false }
        )
    }

    Scaffold(topBar = { TopAppBarRecipes() }) { paddingValues ->
        recipesResponse?.let {
            RecipesList(
                recipes = recipesResponse.recipes,
                onClickRecipe = { recipe ->
                    recipesViewModel.setRecipe(recipe)
                    isInstructionsDialogVisible = true
                },
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(horizontal = 20.dp)
            )
        }
    }
}



