package com.example.todolistp1.domain.usecase

import com.example.todolistp1.domain.ToDoListRepository
import com.example.todolistp1.domain.model.ToDoListItem
import com.example.todolistp1.domain.model.toDomain
import com.example.todolistp1.presentation.usecase.GetToDoItemByIDUseCase
import javax.inject.Inject

class GetToDoItemByIDUseCaseImpl @Inject constructor(val toDoListRepository: ToDoListRepository): GetToDoItemByIDUseCase {
    override suspend fun getItem(id: Int): ToDoListItem {
        return toDoListRepository.getToDoListItem(id).toDomain()
    }
}