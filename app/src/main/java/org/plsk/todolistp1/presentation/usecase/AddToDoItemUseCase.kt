package org.plsk.todolistp1.presentation.usecase

import org.plsk.todolistp1.domain.model.ToDoListItem

interface AddToDoItemUseCase {
    suspend operator fun invoke(toDoCardData: ToDoListItem): Int
}