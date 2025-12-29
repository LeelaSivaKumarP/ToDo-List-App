package org.plsk.todolistp1.addtask

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.plsk.todolistp1.presentation.model.ToDoCardData
import org.plsk.todolistp1.presentation.model.toDomain
import org.plsk.todolistp1.presentation.model.toPresentation
import org.plsk.todolistp1.presentation.usecase.AddToDoItemUseCase
import org.plsk.todolistp1.presentation.usecase.GetToDoItemByIDUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.plsk.todolistp1.home.ToDoItemCard
import javax.inject.Inject

@HiltViewModel
class AddItemViewModel @Inject constructor(
    val addToDoItemUseCase: AddToDoItemUseCase,
    val getToDoItemByIDUseCase: GetToDoItemByIDUseCase
) : ViewModel() {
     val todoItem = mutableStateOf<ToDoCardData>(ToDoCardData(title = ""))

    fun addToDB(toDoCardData: ToDoCardData) {
        viewModelScope.launch {
            addToDoItemUseCase(toDoCardData.toDomain())
        }
    }

    fun getItem(id: Int) {
        viewModelScope.launch {
            todoItem.value = getToDoItemByIDUseCase.getItem(id)?.toPresentation() ?: ToDoCardData(title = "")
        }
    }
}