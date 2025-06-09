package com.example.todolistp1.home.presentation.usecase

import com.example.todolistp1.home.domain.model.ToDoListItem

interface DeleteToDoDataUseCase {
    suspend operator fun invoke(toDoListItem: ToDoListItem): Int
}