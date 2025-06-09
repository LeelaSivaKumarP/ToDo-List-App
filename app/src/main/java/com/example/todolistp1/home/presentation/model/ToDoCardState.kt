package com.example.todolistp1.home.presentation.model

import com.example.todolistp1.home.domain.model.ToDoListItem

data class ToDoCardState(
    var isLoading: Boolean = false,
    var isError: Boolean = false,
    var data: List<ToDoListItem> = emptyList()
)
