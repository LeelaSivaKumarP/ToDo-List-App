package com.example.todolistp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.todolistp1.addtask.AddItemScreen
import com.example.todolistp1.addtask.AddItemViewModel
import com.example.todolistp1.home.HomeScreen
import com.example.todolistp1.home.HomeScreenNavArg
import com.example.todolistp1.home.HomeViewModel
import com.example.todolistp1.ui.theme.TODOListP1Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val homeViewModel: HomeViewModel by viewModels<HomeViewModel>()
    val addViewModel: AddItemViewModel by viewModels<AddItemViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TODOListP1Theme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = HomeScreenNavArg) {
                    composable<HomeScreenNavArg> {
                        HomeScreen(navController, homeViewModel)
                    }

                    composable<AddItemScreen> {
                        AddItemScreen(navController, viewModel = addViewModel)
                    }
                }

            }
        }
    }
}
