package com.example.todolistp1.addtask.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolistp1.ui.theme.TODOListP1Theme

@Composable
fun AddItemScreen(modifier: Modifier = Modifier) {

}


@Composable
fun DropDownList(
    selectItemIndex: Int,
    menuItems: List<String>,
    isExpanded: Boolean,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        var state by rememberSaveable { mutableStateOf(false) }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 50.dp).clickable(enabled = true, onClick = { state = !state }),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(menuItems[selectItemIndex])
            Icon(Icons.Default.ArrowDropDown, contentDescription = null)

        }
        DropdownMenu(expanded = state, onDismissRequest = { }) {
            menuItems.forEach { item ->
                DropdownMenuItem(text = { Text(item) }, onClick = {})
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewDropDownList(modifier: Modifier = Modifier) {
    TODOListP1Theme {
        DropDownList(1, listOf("abc", "def", "ghi"), true)
    }
}

