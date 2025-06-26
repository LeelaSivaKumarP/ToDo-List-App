package com.example.todolistp1.home

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.todolistp1.ui.theme.TODOListP1Theme

@Composable
fun ToDoItemCard(
    checkState: Boolean,
    onCheckChanged: (Boolean) -> Unit,
    onDeleteClick: () -> Unit,
    onTodoCardClick: () -> Unit,
    title: String,
    modifier: Modifier = Modifier,
    description: String? = null,
    repeatMode: Boolean = false,
    category: String? = null

) {
    ConstraintLayout(modifier = modifier.clickable{ onTodoCardClick() }
        .fillMaxWidth()
        .border(1.dp, Color.Black)) {
        val (checkButton, titleCon, descriptionCon, detailsCon, deleteButton) = createRefs()
        Checkbox(
            checked = checkState,
            onCheckedChange = onCheckChanged,
            colors = CheckboxDefaults.colors(
                uncheckedColor = Color.Black,
                checkedColor = Color.Green
            ),
            modifier = Modifier
                .constrainAs(checkButton) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }
                .padding(start = 5.dp)
        )
        Text(text = title, modifier = Modifier.constrainAs(titleCon) {
            top.linkTo(parent.top)
            start.linkTo(checkButton.end)
        })

        if (description != null) {
            ToDoCardDescription(
                description,
                repeatMode,
                modifier = Modifier.constrainAs(descriptionCon) {
                    start.linkTo(checkButton.end)
                    top.linkTo(titleCon.bottom)
                })
            category?.let {
                Text(it, modifier = Modifier.constrainAs(detailsCon) {
                    top.linkTo(descriptionCon.bottom)
                    start.linkTo(checkButton.end)
                })
            }
        } else {
            category?.let {
                Text(it, modifier = Modifier.constrainAs(detailsCon) {
                    top.linkTo(titleCon.bottom)
                    start.linkTo(checkButton.end)
                })
            }
        }

        IconButton(onClick = onDeleteClick, modifier = Modifier
            .constrainAs(deleteButton) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            }
            .padding(end = 15.dp)) {
            Icon(Icons.Outlined.Delete, tint = Color.Red, contentDescription = null)
        }
    }
}

@Preview
@Composable
fun PreviewToDoItemCard(modifier: Modifier = Modifier) {
    TODOListP1Theme {
        ToDoItemCard(
            checkState = false,
            onCheckChanged = {},
            onDeleteClick = {},
            onTodoCardClick = {},
            title = "Title",
            description = "Description",
            repeatMode = true,
            category = "Personal"
        )
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
    Text(text = annotatedText, inlineContent = inlineText, modifier = modifier)
}
