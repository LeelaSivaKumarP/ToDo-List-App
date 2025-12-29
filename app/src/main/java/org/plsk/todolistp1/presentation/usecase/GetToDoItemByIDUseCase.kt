package org.plsk.todolistp1.presentation.usecase

import org.plsk.todolistp1.domain.model.ToDoListItem

interface GetToDoItemByIDUseCase {
    suspend fun getItem(id: Int): ToDoListItem?
}