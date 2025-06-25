package com.example.todolistp1.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistp1.presentation.model.ToDoCardData
import com.example.todolistp1.presentation.model.toDomain
import com.example.todolistp1.presentation.model.toPresentationList
import com.example.todolistp1.presentation.usecase.DeleteToDoDataUseCase
import com.example.todolistp1.presentation.usecase.FetchToDoDataUseCase
import com.example.todolistp1.presentation.usecase.UpdateToDoDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    val fetchToDoDataUseCase: FetchToDoDataUseCase,
    val updateToDoDataUseCase: UpdateToDoDataUseCase,
    val deleteToDoDataUseCase: DeleteToDoDataUseCase
) : ViewModel() {
    private var _uiState: MutableStateFlow<HomeState> =
        MutableStateFlow(HomeState().apply { isLoading = true })
    var uiState: StateFlow<HomeState> = _uiState

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            fetchToDoDataUseCase.invoke().map {
                it.toPresentationList()
            }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList()).collect {
                _uiState.value = HomeState(data = it)
            }

        }
    }

    fun changeStateOfCard(toDoCardData: ToDoCardData, newState: Boolean) {
        viewModelScope.launch {
            updateToDoDataUseCase(toDoCardData.copy(isChecked = newState).toDomain())
        }
    }

    fun deleteCard(toDoCardData: ToDoCardData) {
        viewModelScope.launch {
            deleteToDoDataUseCase(toDoCardData.toDomain())
        }
    }

}

fun dummyUIStateData(): List<ToDoCardData> {
    return buildList {
        add(ToDoCardData(isChecked = false, title = "Title 1", dateTime = "Description 1"))
        add(ToDoCardData(isChecked = false, title = "Title 2", dateTime = "Description 2"))
        add(ToDoCardData(isChecked = false, title = "Title 3", dateTime = "Description 3"))
        add(ToDoCardData(isChecked = false, title = "Title 4", dateTime = "Description 4"))
        add(ToDoCardData(isChecked = false, title = "Title 5", dateTime = "Description 5"))
        add(ToDoCardData(isChecked = false, title = "Title 6", dateTime = "Description 6"))
        add(ToDoCardData(isChecked = false, title = "Title 7", dateTime = "Description 7"))

    }
}


