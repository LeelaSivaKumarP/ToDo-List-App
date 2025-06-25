package com.example.todolistp1.addtask

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.todolistp1.ui.theme.TODOListP1Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@Serializable
object AddItemScreen

@Composable
fun AddItemScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: AddItemViewModel = viewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    var textFieldData by remember { mutableStateOf("") }
    Scaffold(floatingActionButton = {
        SaveFloatingActionButton(onClick = {
            viewModel.addToDB(data = textFieldData)
            coroutineScope.launch {
                delay(500)
                navController.navigateUp()
            }
        })
    }) { innerPadding ->
        Column(modifier = modifier.padding(innerPadding)) {
            ToDoTaskEntry(
                titleText = "What is to be done?",
                textFieldData = textFieldData,
                onTextChange = { newData -> textFieldData = newData })
        }
    }
}


@Composable
fun DropDownList(
    selectItemIndex: Int,
    menuItems: List<String>,
    isExpanded: Boolean,
    modifier: Modifier = Modifier,
    selectedIndex: () -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        var state by rememberSaveable { mutableStateOf(false) }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 50.dp)
                .clickable(enabled = true, onClick = { state = !state }),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(menuItems[selectItemIndex])
            Icon(Icons.Default.ArrowDropDown, contentDescription = null)
        }
        DropdownMenu(expanded = state, onDismissRequest = { }) {
            menuItems.forEach { item ->
                DropdownMenuItem(text = { Text(item) }, onClick = selectedIndex)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewDropDownList(modifier: Modifier = Modifier) {
    TODOListP1Theme {
        DropDownList(1, listOf("abc", "def", "ghi"), true, selectedIndex = {})
    }
}

@Composable
fun ToDoTaskEntry(
    titleText: String,
    textFieldData: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        Text(text = titleText)
        TextField(value = textFieldData, onValueChange = onTextChange)
    }
}

@Composable
fun SaveFloatingActionButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    FloatingActionButton(onClick = onClick) {
        Icon(Icons.Default.Check, contentDescription = null)
    }
}