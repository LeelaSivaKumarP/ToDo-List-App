package com.example.todolistp1.home

import com.example.todolistp1.presentation.model.ToDoCardData

data class HomeState(
    var isLoading: Boolean = false,
    var isError: Boolean = false,
    var data: List<ToDoCardData> = emptyList()
)