package com.example.todolistp1.addtask.navigation

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.todolistp1.addtask.AddItemScreen

fun NavGraphBuilder.navigateAddEditScreen(
    navigateBack: () -> Unit,
    navigateBackButtonClick: () -> Unit
) {
    composable<AddItemScreen> { toDoItem, ->
        val cardId = toDoItem.toRoute<AddItemScreen>()
        AddItemScreen(
            cardId.toDoCardId,
            navigateBack = navigateBack,
            navigateBackButtonClick = navigateBackButtonClick
        )
    }
}