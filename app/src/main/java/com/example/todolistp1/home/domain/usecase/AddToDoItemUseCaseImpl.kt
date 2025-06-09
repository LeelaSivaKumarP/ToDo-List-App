package com.example.todolistp1.home.domain.usecase

import com.example.todolistp1.home.domain.model.ToDoListItem
import com.example.todolistp1.home.domain.ToDoListRepository
import com.example.todolistp1.home.domain.model.toData
import com.example.todolistp1.home.presentation.usecase.AddToDoItemUseCase
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class AddToDoItemUseCaseImpl @Inject constructor(val toDoListRepository: ToDoListRepository): AddToDoItemUseCase {
    override suspend fun invoke(toDoCardData: ToDoListItem): Int {
        return toDoListRepository.insertToDoListItem(toDoCardData.toData())
    }

}