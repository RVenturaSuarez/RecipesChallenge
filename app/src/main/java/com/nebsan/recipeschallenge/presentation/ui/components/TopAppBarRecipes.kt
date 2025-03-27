package com.nebsan.recipeschallenge.presentation.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.nebsan.recipeschallenge.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarRecipes() {
    CenterAlignedTopAppBar(title = { Text(text = stringResource(id = R.string.topAppBar_recipes_title)) })
}