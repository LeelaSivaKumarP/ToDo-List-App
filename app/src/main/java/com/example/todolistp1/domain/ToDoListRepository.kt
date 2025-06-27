package com.example.todolistp1.domain

import com.example.todolistp1.data.localdb.ToDoItemDBModel
import kotlinx.coroutines.flow.Flow

interface ToDoListRepository {
    suspend fun getToDoListData(): Flow<List<ToDoItemDBModel>>
    suspend fun getToDoListItem(id: Int): ToDoItemDBModel
    suspend fun deleteToDoListItem(toDoItemDBModel: ToDoItemDBModel): Int
    suspend fun insertToDoListItem(toDoItemDBModel: ToDoItemDBModel): Int
    suspend fun updateToDoListItem(toDoItemDBModel: ToDoItemDBModel): Int
}