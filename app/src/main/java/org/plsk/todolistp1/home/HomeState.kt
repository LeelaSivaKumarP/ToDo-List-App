package org.plsk.todolistp1.home

import org.plsk.todolistp1.presentation.model.ToDoCardData

data class HomeState(
    var isLoading: Boolean = false,
    var isError: Boolean = false,
    var data: List<ToDoCardData> = emptyList()
)