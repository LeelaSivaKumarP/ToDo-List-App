package org.plsk.todolistp1.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.plsk.todolistp1.home.HomeScreen
import org.plsk.todolistp1.presentation.model.ToDoCardData
import kotlinx.serialization.Serializable

@Serializable
object HomeScreenNavArg

fun NavGraphBuilder.navigateHome(onAddTaskButtonClick: () -> Unit, onClickToDoCard: (ToDoCardData) -> Unit) {
    composable<HomeScreenNavArg> {
        HomeScreen(onAddTaskButtonClick = onAddTaskButtonClick, onClickToDoCard = onClickToDoCard)
    }
}