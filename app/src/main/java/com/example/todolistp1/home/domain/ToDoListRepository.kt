package com.example.todolistp1.home.domain

import com.example.todolistp1.home.data.localdb.ToDoItemDBModel

interface ToDoListRepository {
    suspend fun getToDoListData(): List<ToDoItemDBModel>
    suspend fun deleteToDoListItem(toDoItemDBModel: ToDoItemDBModel): Int
    suspend fun insertToDoListItem(toDoItemDBModel: ToDoItemDBModel): Int
    suspend fun updateToDoListItem(toDoItemDBModel: ToDoItemDBModel): Int
}