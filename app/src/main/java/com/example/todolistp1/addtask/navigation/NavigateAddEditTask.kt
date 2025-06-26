package com.example.todolistp1.addtask.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.todolistp1.addtask.AddItemScreen

fun NavGraphBuilder.navigateAddEditScreen(navigateBack: () -> Unit) {
    composable<AddItemScreen> {
        AddItemScreen(navigateBack = navigateBack)
    }
}