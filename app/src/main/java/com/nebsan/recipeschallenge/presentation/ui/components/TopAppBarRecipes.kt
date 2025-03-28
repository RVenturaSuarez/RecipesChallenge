package com.nebsan.recipeschallenge.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nebsan.recipeschallenge.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarRecipes() {
    CenterAlignedTopAppBar(title = {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_recipe),
                contentDescription = stringResource(id = R.string.content_description_icon_recipe)
            )
            Text(text = stringResource(id = R.string.topAppBar_recipes_title))
        }
    })
}