package org.plsk.todolistp1.addtask

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import org.plsk.todolistp1.ui.theme.TODOListP1Theme
import kotlinx.serialization.Serializable

@Serializable
class AddItemScreen(val toDoCardId: Int)

@Composable
fun AddItemScreen(
    cardId: Int,
    navigateBack: () -> Unit,
    navigateBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AddItemViewModel = hiltViewModel<AddItemViewModel>()
) {
    var textFieldData by viewModel.todoItem

    LaunchedEffect(Unit) {
        viewModel.getItem(cardId)
    }
    Scaffold(
        floatingActionButton = {
            SaveFloatingActionButton(onClick = {
                viewModel.addToDB(toDoCardData = textFieldData)
                //TODO: Edge Case, rare but happens.
                //1. If Viewmodel lifecycle ends before DB operation, coroutine will cancel and DB operation will not be executed.
                //fix: Listen to the DB operation and upon success, trigger an Event to navigate UP. In-Between show Loader kind of thing.
                navigateBack()
            })
        },
        topBar = {
            AddEditTopAppbar(navigateBackButtonClick)
        }) { innerPadding ->
        Column(modifier = modifier.padding(innerPadding)) {
            ToDoTaskEntry(
                titleText = "What is to be done?",
                textFieldData = textFieldData.title,
                onTextChange = { newData -> textFieldData = textFieldData.copy(title = newData) })
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditTopAppbar(navigateBackButtonClick: () -> Unit, modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text("Provide Task", fontSize = 18.sp)
        },
        navigationIcon = {
            IconButton(onClick = navigateBackButtonClick) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Blue,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        )
    )
}