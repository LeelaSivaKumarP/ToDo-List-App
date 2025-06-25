package com.example.todolistp1.presentation.model

import com.example.todolistp1.domain.model.ToDoListItem

data class ToDoCardData(
    val id: Int? = null,
    var isChecked: Boolean = false,
    val title: String,
    var dateTime: String? = null,
    var repeatMode: Boolean = false,
    var category: String? = null
)

fun List<ToDoListItem>.toPresentationList(): List<ToDoCardData> {
    return this.map {
        ToDoCardData(
            id = it.id,
            isChecked = it.isChecked,
            title = it.title,
            dateTime = it.dateTime,
            repeatMode = it.repeatMode,
            category = it.category
        )
    }
}

fun ToDoCardData.toDomain(): ToDoListItem {
    return ToDoListItem(
        id = this.id ?: -1,
        isChecked = this.isChecked,
        title = this.title,
        dateTime = this.dateTime,
        repeatMode = this.repeatMode,
    )
}
