package com.nebsan.recipeschallenge.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nebsan.recipeschallenge.R
import com.nebsan.recipeschallenge.domain.model.Recipe

@Composable
fun RecipeInstructionsDialog(
    selectedRecipe: Recipe,
    onDismissRequest: () -> Unit,
) {
    AlertDialog(
        icon = { IconRecipeInstructionsDialog(selectedRecipe.name) },
        title = { Text(text = stringResource(id = R.string.instructions_dialog_title)) },
        text = { InstructionsList(instructions = selectedRecipe.instructions) },
        onDismissRequest = { onDismissRequest() },
        confirmButton = {
            Button(onClick = { onDismissRequest() }) {
                Text(text = stringResource(id = R.string.close_info_recipe_btn))
            }
        }
    )
}


@Composable
private fun IconRecipeInstructionsDialog(
    recipeName: String,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_recipe),
            contentDescription = stringResource(
                id = R.string.content_description_icon_recipe
            )
        )
        Text(text = recipeName)
    }
}

@Composable
private fun InstructionsList(instructions: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        itemsIndexed(instructions) { index, instruction ->
            Instruction(
                index = index,
                instruction = instruction,
                isLastInstruction = index == instructions.size - 1
            )
        }
    }
}

@Composable
private fun Instruction(index: Int, instruction: String, isLastInstruction: Boolean) {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Badge(containerColor = Color.Black, contentColor = Color.White) {
                Text(text = "${index + 1}", modifier = Modifier.padding(2.dp))
            }
            Text(text = instruction)
        }
        if (!isLastInstruction) HorizontalDivider()
    }

}
