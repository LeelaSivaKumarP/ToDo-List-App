package com.example.todolistp1.home.presentation.usecase

import com.example.todolistp1.home.presentation.model.ToDoCardData

interface DeleteToDoDataUseCase {
    fun deleteToDo(toDoCardData: ToDoCardData): Boolean
}