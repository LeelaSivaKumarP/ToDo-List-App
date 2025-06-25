package com.example.todolistp1.presentation.usecase

import com.example.todolistp1.domain.model.ToDoListItem

interface UpdateToDoDataUseCase {
    suspend operator fun invoke(toDoListItem: ToDoListItem): Int
}