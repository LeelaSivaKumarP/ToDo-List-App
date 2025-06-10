package com.example.todolistp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.example.todolistp1.home.presentation.HomeScreen
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
                NavHost(navController = navController, startDestination = "One") {
                    composable(route = "One") {
                        HomeScreen(navController)
                    }
                    composable(route = "Two") {
                        Text(text = "Two, The second screen.", style = TextStyle.Default.copy(fontSize = 32.sp))
                    }
                    dialog("Dialog") {
                        Box(modifier = Modifier.fillMaxSize(0.3f).background(Color.White), contentAlignment = Alignment.Center) {
                            Text(text = "This should be displayed in dialog.")
                        }

                    }
                }

            }
        }
    }
}
