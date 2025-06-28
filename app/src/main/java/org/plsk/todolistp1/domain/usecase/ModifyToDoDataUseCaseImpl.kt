package org.plsk.todolistp1.domain.usecase

import org.plsk.todolistp1.domain.ToDoListRepository
import org.plsk.todolistp1.domain.model.ToDoListItem
import org.plsk.todolistp1.domain.model.toData
import org.plsk.todolistp1.presentation.usecase.UpdateToDoDataUseCase
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class ModifyToDoDataUseCaseImpl @Inject constructor(val toDoListRepository: ToDoListRepository) :
    UpdateToDoDataUseCase {
    override suspend fun invoke(toDoListItem: ToDoListItem): Int {
        return toDoListRepository.updateToDoListItem(toDoListItem.toData())
    }
}