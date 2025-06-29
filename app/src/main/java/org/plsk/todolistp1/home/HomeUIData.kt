package org.plsk.todolistp1.home

import org.plsk.todolistp1.presentation.model.ToDoCardData

data class HomeUIData(
    var data: List<ToDoCardData> = emptyList(),
    val hidePendingItems: Boolean = false
)