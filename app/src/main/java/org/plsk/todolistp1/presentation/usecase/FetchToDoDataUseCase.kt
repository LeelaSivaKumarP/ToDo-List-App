package org.plsk.todolistp1.presentation.usecase

import org.plsk.todolistp1.domain.model.ToDoListItem
import kotlinx.coroutines.flow.Flow

interface FetchToDoDataUseCase {
    suspend operator fun invoke(): Flow<List<ToDoListItem>>
}