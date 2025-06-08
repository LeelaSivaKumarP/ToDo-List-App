package com.example.todolistp1.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolistp1.ui.theme.TODOListP1Theme

@Composable
fun ToDoItemCard(
    checkState: Boolean,
    onCheckChanged: (Boolean) -> Unit,
    title: String,
    modifier: Modifier = Modifier,
    description: String? = null,
    repeatMode: Boolean = false,
    category: String? = null

) {
    Row(modifier = modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(10))
        .background(Color(79, 135, 180)),
        verticalAlignment = Alignment.Top) {
        Checkbox(
            checked = checkState,
            onCheckedChange = onCheckChanged,
            colors = CheckboxDefaults.colors(uncheckedColor = Color.White),
            modifier = Modifier.offset(y = (-10).dp)
        )
        Column(modifier = Modifier.alignByBaseline()) {
            Text(title)
            description?.let {
                ToDoCardDescription(it, repeatMode)
            }
            category?.let {
                Text(it)
            }
        }
    }
}

@Preview
@Composable
fun PreviewToDoItemCard(modifier: Modifier = Modifier) {
    TODOListP1Theme {
        ToDoItemCard(false, {}, title = "Title", description = "Description", repeatMode = true, category = "Personal")
    }
}

@Composable
fun ToDoCardDescription(dateTime: String, isRepeatMode: Boolean, modifier: Modifier = Modifier) {
    val inlineText = mapOf(
        "inlineText" to InlineTextContent(
            placeholder = Placeholder(15.sp, 15.sp, PlaceholderVerticalAlign.Center),
        ) {
            Icon(Icons.Default.Refresh, contentDescription = null)
        })
    val annotatedText = buildAnnotatedString {
        withStyle(SpanStyle(color = Color.Blue)) {
            append(dateTime)
        }
        if (isRepeatMode) {
            append(" ")
            appendInlineContent("inlineText", "\uFFFD")
            append(" ")
        }
    }
    Text(text = annotatedText, inlineContent = inlineText)
}
