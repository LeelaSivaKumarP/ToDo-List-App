package com.example.todolistp1.home.domain.usecase

import com.example.todolistp1.home.domain.model.ToDoListItem
import com.example.todolistp1.home.domain.ToDoListRepository
import com.example.todolistp1.home.domain.model.toData
import com.example.todolistp1.home.presentation.usecase.DeleteToDoDataUseCase
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class DeleteToDoListUseCaseImpl @Inject constructor(val toDoListRepository: ToDoListRepository): DeleteToDoDataUseCase {
    override suspend fun invoke(toDoListItem: ToDoListItem): Int {
        return toDoListRepository.deleteToDoListItem(toDoListItem.toData())
    }
}