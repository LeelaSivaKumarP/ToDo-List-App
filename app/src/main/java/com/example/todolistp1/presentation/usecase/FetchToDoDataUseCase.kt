package com.example.todolistp1.presentation.usecase

import com.example.todolistp1.domain.model.ToDoListItem
import kotlinx.coroutines.flow.Flow

interface FetchToDoDataUseCase {
    suspend operator fun invoke(): Flow<List<ToDoListItem>>
}