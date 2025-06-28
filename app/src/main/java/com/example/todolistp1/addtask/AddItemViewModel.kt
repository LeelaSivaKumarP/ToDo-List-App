package com.example.todolistp1.addtask

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistp1.domain.model.ToDoListItem
import com.example.todolistp1.presentation.model.ToDoCardData
import com.example.todolistp1.presentation.model.toDomain
import com.example.todolistp1.presentation.model.toPresentation
import com.example.todolistp1.presentation.usecase.AddToDoItemUseCase
import com.example.todolistp1.presentation.usecase.GetToDoItemByIDUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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
            todoItem.value = getToDoItemByIDUseCase.getItem(id).toPresentation()
        }
    }
}