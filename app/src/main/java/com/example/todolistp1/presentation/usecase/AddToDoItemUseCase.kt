package com.example.todolistp1.presentation.usecase

import com.example.todolistp1.domain.model.ToDoListItem

interface AddToDoItemUseCase {
    suspend operator fun invoke(toDoCardData: ToDoListItem): Int
}