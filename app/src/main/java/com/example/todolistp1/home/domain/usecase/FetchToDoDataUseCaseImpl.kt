package com.example.todolistp1.home.domain.usecase

import com.example.todolistp1.home.domain.model.ToDoListItem
import com.example.todolistp1.home.domain.ToDoListRepository
import com.example.todolistp1.home.domain.model.toDomain
import com.example.todolistp1.home.presentation.usecase.FetchToDoDataUseCase
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class FetchToDoDataUseCaseImpl @Inject constructor(val toDoListRepository: ToDoListRepository): FetchToDoDataUseCase {
    override suspend fun invoke(): List<ToDoListItem> {
        return toDoListRepository.getToDoListData().map {
            it.toDomain()
        }
    }
}