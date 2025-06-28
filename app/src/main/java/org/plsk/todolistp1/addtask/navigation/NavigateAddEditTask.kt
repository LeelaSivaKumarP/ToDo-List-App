package org.plsk.todolistp1.addtask.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import org.plsk.todolistp1.addtask.AddItemScreen

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