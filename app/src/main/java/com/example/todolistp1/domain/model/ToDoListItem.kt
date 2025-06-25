package com.example.todolistp1.domain.model

import com.example.todolistp1.data.localdb.ToDoItemDBModel

data class ToDoListItem(
    val id: Int = 0,
    var isChecked: Boolean,
    val title: String,
    var dateTime: String? = null,
    var repeatMode: Boolean = false,
    var category: String? = null
)

fun ToDoListItem.toData(): ToDoItemDBModel {
    return ToDoItemDBModel(
        id = this.id,
        isChecked = this.isChecked,
        title = this.title,
        dateTime = this.dateTime,
        repeatMode = this.repeatMode,
        category = this.category
    )
}

fun ToDoItemDBModel.toDomain(): ToDoListItem {
    return ToDoListItem(
        id = this.id,
        isChecked = this.isChecked,
        title = this.title,
        dateTime = this.dateTime,
        repeatMode = this.repeatMode,
        category = this.category
    )
}

fun List<ToDoItemDBModel>.toDomainList(): List<ToDoListItem> {
    return this.map {
        it.toDomain()
    }
}
