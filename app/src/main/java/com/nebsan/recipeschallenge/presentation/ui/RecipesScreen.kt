package com.nebsan.recipeschallenge.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nebsan.recipeschallenge.presentation.ui.components.CircularLoadingInfo
import com.nebsan.recipeschallenge.presentation.ui.components.NoDataFoundInfo
import com.nebsan.recipeschallenge.presentation.ui.components.RecipeInstructionsDialog
import com.nebsan.recipeschallenge.presentation.ui.components.RecipesList
import com.nebsan.recipeschallenge.presentation.ui.components.TopAppBarRecipes
import com.nebsan.recipeschallenge.presentation.viewmodel.RecipesViewModel
import com.nebsan.recipeschallenge.utils.ResultRecipes

@Composable
fun RecipesScreen(recipesViewModel: RecipesViewModel = hiltViewModel()) {

    val resultRecipes = recipesViewModel.resultRecipes.collectAsState().value
    val selectedRecipe = recipesViewModel.selectedRecipe.value

    var isInstructionsDialogVisible by rememberSaveable { mutableStateOf(false) }


    if (isInstructionsDialogVisible && selectedRecipe != null) {
        RecipeInstructionsDialog(
            selectedRecipe = selectedRecipe,
            onDismissRequest = { isInstructionsDialogVisible = false }
        )
    }

    Scaffold(topBar = { TopAppBarRecipes() }) { paddingValues ->
        when (resultRecipes) {
            ResultRecipes.Loading -> { CircularLoadingInfo(paddingValues = paddingValues) }

            ResultRecipes.Error -> {
                NoDataFoundInfo(
                    paddingValues = paddingValues,
                    onReloadClick = { recipesViewModel.reloadData() }
                )
            }

            is ResultRecipes.Success -> {
                RecipesList(
                    recipes = resultRecipes.recipesResponse.recipes,
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
}



