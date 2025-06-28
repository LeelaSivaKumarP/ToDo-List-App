package org.plsk.todolistp1.domain.usecase

import org.plsk.todolistp1.domain.ToDoListRepository
import org.plsk.todolistp1.domain.model.ToDoListItem
import org.plsk.todolistp1.domain.model.toData
import org.plsk.todolistp1.presentation.usecase.AddToDoItemUseCase
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class AddToDoItemUseCaseImpl @Inject constructor(val toDoListRepository: ToDoListRepository) :
    AddToDoItemUseCase {
    override suspend fun invoke(toDoCardData: ToDoListItem): Int {
        return toDoListRepository.insertToDoListItem(toDoCardData.toData())
    }

}