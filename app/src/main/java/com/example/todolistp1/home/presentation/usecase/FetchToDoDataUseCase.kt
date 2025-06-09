package com.example.todolistp1.home.presentation.usecase

import com.example.todolistp1.home.domain.model.ToDoListItem

interface FetchToDoDataUseCase {
    suspend operator fun invoke(): List<ToDoListItem>
}