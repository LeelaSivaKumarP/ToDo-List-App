package com.example.todolistp1.presentation.usecase

import com.example.todolistp1.domain.model.ToDoListItem

interface GetToDoItemByIDUseCase {
    suspend fun getItem(id: Int): ToDoListItem
}