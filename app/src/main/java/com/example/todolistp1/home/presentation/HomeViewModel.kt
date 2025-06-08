package com.example.todolistp1.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistp1.home.presentation.model.ToDoCardData
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {
    private val uiState_: MutableStateFlow<List<ToDoCardData>> = MutableStateFlow(emptyList())
    val uiState: StateFlow<List<ToDoCardData>> = uiState_

    init {
        viewModelScope.launch {
            delay(4000)
            fetchData()
        }
    }
    fun fetchData() {
        uiState_.value = dummyUIStateData()
    }

    fun changeStateOfCard(toDoCardData: ToDoCardData, newState: Boolean) {
         val newState = uiState_.value.map {
            if (it == toDoCardData) {
                it.copy(isChecked = newState)
            } else {
                it
            }
        }
        uiState_.value = newState
    }
}

fun dummyUIStateData(): List<ToDoCardData> {
    return buildList {
        add(ToDoCardData(isChecked = false, title = "Title 1", "Description 1"))
        add(ToDoCardData(isChecked = false, title = "Title 2", "Description 2"))
        add(ToDoCardData(isChecked = false, title = "Title 3", "Description 3"))
        add(ToDoCardData(isChecked = false, title = "Title 4", "Description 4"))
        add(ToDoCardData(isChecked = false, title = "Title 5", "Description 5"))
        add(ToDoCardData(isChecked = false, title = "Title 6", "Description 6"))
        add(ToDoCardData(isChecked = false, title = "Title 7", "Description 7"))

    }
}


