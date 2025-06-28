package org.plsk.todolistp1.domain.usecase

import org.plsk.todolistp1.domain.ToDoListRepository
import org.plsk.todolistp1.domain.model.ToDoListItem
import org.plsk.todolistp1.domain.model.toDomainList
import org.plsk.todolistp1.presentation.usecase.FetchToDoDataUseCase
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@ViewModelScoped
class FetchToDoDataUseCaseImpl @Inject constructor(val toDoListRepository: ToDoListRepository) :
    FetchToDoDataUseCase {
    override suspend fun invoke(): Flow<List<ToDoListItem>> {
        return toDoListRepository.getToDoListData().map {
            it.toDomainList()
        }
    }
}