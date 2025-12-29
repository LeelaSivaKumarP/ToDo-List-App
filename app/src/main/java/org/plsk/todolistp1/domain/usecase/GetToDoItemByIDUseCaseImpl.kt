package org.plsk.todolistp1.domain.usecase

import org.plsk.todolistp1.domain.ToDoListRepository
import org.plsk.todolistp1.domain.model.ToDoListItem
import org.plsk.todolistp1.domain.model.toDomain
import org.plsk.todolistp1.presentation.usecase.GetToDoItemByIDUseCase
import javax.inject.Inject

class GetToDoItemByIDUseCaseImpl @Inject constructor(val toDoListRepository: ToDoListRepository) :
    GetToDoItemByIDUseCase {
    override suspend fun getItem(id: Int): ToDoListItem? {
        return toDoListRepository.getToDoListItem(id)?.toDomain()
    }
}