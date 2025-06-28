package org.plsk.todolistp1.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import org.plsk.todolistp1.R
import org.plsk.todolistp1.presentation.model.ToDoCardData
import org.plsk.todolistp1.ui.theme.TODOListP1Theme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onAddTaskButtonClick: () -> Unit,
    onClickToDoCard: (ToDoCardData) -> Unit,
    viewModel: HomeViewModel = hiltViewModel<HomeViewModel>(),
    modifier: Modifier = Modifier
) {
    val data by viewModel.uiState.collectAsState()
    Scaffold(
        floatingActionButton = { CustomFloatingActionButton(onAddTaskButtonClick) },
        topBar = { CustomTopAppBar() },
        modifier = modifier.fillMaxSize()
    ) { padding ->
        HomeContentScreen(
            data,
            viewModel::changeStateOfCard,
            viewModel::deleteCard,
            onClickToDoCard,
            modifier = Modifier.padding(padding)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(modifier: Modifier = Modifier) {
    var exp by remember { mutableStateOf(false) }
    Box(
        contentAlignment = Alignment.TopCenter, modifier = modifier
            .background(Color.Green)
    ) {
        TopAppBar(
            title = {
                Row {
                    Text("Home", modifier = Modifier.padding(horizontal = 15.dp))
                    Icon(
                        painterResource(id = R.drawable.arrow_drop_down),
                        contentDescription = null
                    )
                }
            },
            actions = {
                IconButton(onClick = {}) { Icon(Icons.Default.Search, contentDescription = null) }
                IconButton(onClick = { exp = !exp }) {
                    Icon(
                        Icons.Default.MoreVert,
                        contentDescription = null
                    )
                }
                DropdownMenu(
                    expanded = exp,
                    onDismissRequest = { exp = false },

                    ) {
                    DropdownMenuItem(
                        text = { Text("Text1") },
                        leadingIcon = { Icon(Icons.Default.AccountBox, contentDescription = null) },
                        onClick = { /* Handle click */ })
                    DropdownMenuItem(text = { Text("Text2") }, onClick = { /* Handle click */ })
                    DropdownMenuItem(text = { Text("Text3") }, onClick = { /* Handle click */ })
                    DropdownMenuItem(text = { Text("Text4") }, onClick = { /* Handle click */ })
                }
            },
            navigationIcon = {
                Icon(
                    Icons.Default.CheckCircle,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(35.dp),
                    contentDescription = null
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                titleContentColor = Color.White,
                containerColor = Color.Blue,
                navigationIconContentColor = Color.White,
                actionIconContentColor = Color.White
            )
        )
    }
}

@Composable
fun CustomFloatingActionButton(navigateToAddEditScreen: () -> Unit, modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = navigateToAddEditScreen,
        modifier = Modifier.clip(CircleShape)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.add_symbol),
            modifier = Modifier.size(30.dp),
            contentDescription = null
        )
    }
}

@Composable
fun HomeContentScreen(
    homeState: HomeState,
    onCheckChanged: (ToDoCardData, Boolean) -> Unit,
    onDeleteButtonClick: (ToDoCardData) -> Unit,
    onClickToDoCard: (ToDoCardData) -> Unit,
    modifier: Modifier = Modifier
) {

    if (homeState.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else if (homeState.isError) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Error", color = Color.Red, fontSize = 20.sp)
        }
    } else {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentPadding = PaddingValues(all = 5.dp),
            verticalArrangement = Arrangement.spacedBy(space = 5.dp)
        ) {
            items(homeState.data) { card ->
                ToDoItemCard(
                    card.isChecked,
                    onCheckChanged = { newVal -> onCheckChanged(card, newVal) },
                    onDeleteClick = { onDeleteButtonClick(card) },
                    onTodoCardClick = { onClickToDoCard(card) },
                    title = card.title,
                    description = card.dateTime,
                    repeatMode = card.repeatMode,
                    category = card.category
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewHomeScreen(
    modifier: Modifier = Modifier
) {
    TODOListP1Theme {
        HomeScreen(onAddTaskButtonClick = { }, onClickToDoCard = {}, modifier = modifier)
    }
}

@Preview
@Composable
fun PreviewHomeContentScreen(modifier: Modifier = Modifier) {
    TODOListP1Theme {
        HomeContentScreen(
            HomeState(isLoading = false, isError = false, data = dummyUIStateData()),
            onCheckChanged = { a, b -> Log.d("TAG", "PreviewHomeContentScreen: $a $b") },
            onDeleteButtonClick = { Log.d("TAG", "PreviewHomeContentScreen: $it") },
            onClickToDoCard = {},
            modifier = modifier
        )
    }
}



