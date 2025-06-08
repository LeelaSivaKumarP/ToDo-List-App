package com.example.todolistp1.home.presentation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Checkbox
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
import androidx.compose.material3.TopAppBarState
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolistp1.R
import com.example.todolistp1.home.presentation.model.ToDoCardData
import com.example.todolistp1.ui.theme.TODOListP1Theme
import kotlinx.coroutines.flow.asStateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel, modifier: Modifier = Modifier) {
    val data by viewModel.uiState.collectAsState()
    Scaffold(
        floatingActionButton = { CustomFloatingActionButton() },
        topBar = { CustomTopAppBar() },
        modifier = modifier.fillMaxSize()
    ) { padding ->
        HomeContentScreen(data, viewModel::changeStateOfCard, modifier = Modifier.padding(padding))
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(modifier: Modifier = Modifier) {
    var exp by remember { mutableStateOf(false) }
    Box(contentAlignment = Alignment.TopCenter, modifier = modifier
        .background(Color.Green)) {
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
                    DropdownMenuItem(text = { Text("Text1") }, leadingIcon = { Icon(Icons.Default.AccountBox, contentDescription = null)}, onClick = { /* Handle click */ })
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
fun CustomFloatingActionButton(modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = {/*TODO: Navigation part*/},
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
fun HomeContentScreen(todoData: List<ToDoCardData>, onCheckChanged: (ToDoCardData, Boolean)-> Unit, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(todoData) {
            ToDoItemCard(it.isChecked,{ newVal -> onCheckChanged(it, newVal) }, title = it.title, description = it.dateTime, repeatMode = it.repeatMode, category = it.category)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewHomeScreen(modifier: Modifier = Modifier) {
    TODOListP1Theme {
        HomeScreen(HomeViewModel())
    }
}

@Preview
@Composable
fun PreviewHomeContentScreen(modifier: Modifier = Modifier) {
    TODOListP1Theme {
        HomeContentScreen(
            dummyUIStateData(),
            onCheckChanged = {a,b -> Log.d("TAG", "PreviewHomeContentScreen: $a $b")}
        )
    }
}



