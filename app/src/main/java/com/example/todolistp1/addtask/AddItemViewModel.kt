package com.example.todolistp1.addtask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistp1.domain.model.ToDoListItem
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

    fun addToDB(isChecked: Boolean = false, data: String) {
        viewModelScope.launch {
            addToDoItemUseCase(ToDoListItem(isChecked = isChecked, title = data))
        }
    }

    fun getItem(id: Int) {
        viewModelScope.launch {
            getToDoItemByIDUseCase.getItem(id)
        }
    }
}