package com.example.todolistp1.home.domain.model

import com.example.todolistp1.home.data.localdb.ToDoItemDBModel

data class ToDoListItem(
    val id: Int,
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
        isChecked =  this.isChecked,
        title = this.title,
        dateTime = this.dateTime,
        repeatMode = this.repeatMode,
        category = this.category
    )
}
