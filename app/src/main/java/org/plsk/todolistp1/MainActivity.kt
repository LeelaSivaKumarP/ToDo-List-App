package org.plsk.todolistp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.plsk.todolistp1.addtask.AddItemScreen
import org.plsk.todolistp1.addtask.navigation.navigateAddEditScreen
import org.plsk.todolistp1.home.navigation.HomeScreenNavArg
import org.plsk.todolistp1.home.navigation.navigateHome
import org.plsk.todolistp1.ui.theme.TODOListP1Theme
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
