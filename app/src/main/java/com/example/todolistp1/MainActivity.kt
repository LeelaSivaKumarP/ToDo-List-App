package com.example.todolistp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.todolistp1.addtask.AddItemScreen
import com.example.todolistp1.addtask.navigation.navigateAddEditScreen
import com.example.todolistp1.home.navigation.HomeScreenNavArg
import com.example.todolistp1.home.navigation.navigateHome
import com.example.todolistp1.ui.theme.TODOListP1Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TODOListP1Theme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = HomeScreenNavArg) {
                    navigateHome(
                        onAddTaskButtonClick = { navController.navigate(AddItemScreen(0)) },
                        onClickToDoCard = { navController.navigate(AddItemScreen(it.id ?: 0)) }
                    )
                    navigateAddEditScreen(
                        navigateBack = { navController.popBackStack() },
                        navigateBackButtonClick = { navController.popBackStack() })
                }

            }
        }
    }
}
