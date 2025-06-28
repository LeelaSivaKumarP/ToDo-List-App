package org.plsk.todolistp1.presentation.usecase

import org.plsk.todolistp1.domain.model.ToDoListItem

interface UpdateToDoDataUseCase {
    suspend operator fun invoke(toDoListItem: ToDoListItem): Int
}