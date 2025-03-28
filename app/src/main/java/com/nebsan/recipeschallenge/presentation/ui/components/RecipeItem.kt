package com.nebsan.recipeschallenge.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nebsan.recipeschallenge.domain.model.Recipe
import com.nebsan.recipeschallenge.ui.theme.RecipesChallengeTheme

@Composable
fun RecipeItem(
    recipe: Recipe,
    onClickRecipe: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier
        .fillMaxWidth()
        .clickable { onClickRecipe() }) {
        Text(
            text = recipe.name,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun RecipeItemPreview() {
    RecipesChallengeTheme {
        RecipeItem(recipe = Recipe(1, "Recipe one", listOf("Instr1, Instr 2")), {})
    }
}