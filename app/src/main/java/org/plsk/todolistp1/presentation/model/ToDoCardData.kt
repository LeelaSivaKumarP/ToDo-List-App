package org.plsk.todolistp1.presentation.model

import org.plsk.todolistp1.domain.model.ToDoListItem

data class ToDoCardData(
    val id: Int? = null,
    var isChecked: Boolean = false,
    val title: String,
    var dateTime: String? = null,
    var repeatMode: Boolean = false,
    var category: String? = null
)

fun ToDoListItem.toPresentation(): ToDoCardData {
    return ToDoCardData(
        id = this.id,
        isChecked = this.isChecked,
        title = this.title,
        dateTime = this.dateTime,
        repeatMode = this.repeatMode,
        category = this.category
    )
}

fun List<ToDoListItem>.toPresentationList(): List<ToDoCardData> {
    return this.map {
        it.toPresentation()
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
