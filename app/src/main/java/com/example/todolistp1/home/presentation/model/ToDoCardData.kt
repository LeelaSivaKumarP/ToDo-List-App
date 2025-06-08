package com.example.todolistp1.home.presentation.model

data class ToDoCardData(
    var isChecked: Boolean,
    val title: String,
    var dateTime: String? = null,
    var repeatMode: Boolean = false,
    var category: String? = null
)
