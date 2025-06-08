package com.example.todolistp1.home.presentation.usecase

import com.example.todolistp1.home.presentation.model.ToDoCardData

interface AddToDoItemUseCase {
    fun toDoItem(toDoCardData: ToDoCardData): Boolean
}