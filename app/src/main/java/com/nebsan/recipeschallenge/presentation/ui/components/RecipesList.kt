package com.nebsan.recipeschallenge.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nebsan.recipeschallenge.domain.model.Recipe

@Composable
fun RecipesList(recipes: List<Recipe>, onClickRecipe: (Recipe) -> Unit, modifier: Modifier) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(5.dp), modifier = modifier
    ) {
        items(recipes) { recipe ->
            RecipeItem(recipe = recipe, onClickRecipe = { onClickRecipe(recipe) })
        }
    }
}