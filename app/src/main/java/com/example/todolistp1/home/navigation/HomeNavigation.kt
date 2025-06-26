package com.example.todolistp1.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.todolistp1.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeScreenNavArg

fun NavGraphBuilder.navigateHome(onAddTaskButtonClick: () -> Unit, onClickToDoCard: () -> Unit ) {
    composable<HomeScreenNavArg> {
        HomeScreen(onAddTaskButtonClick = onAddTaskButtonClick, onClickToDoCard = onClickToDoCard)
    }
}