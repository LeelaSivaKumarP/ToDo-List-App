package com.example.todolistp1.home.domain

import com.example.todolistp1.home.data.localdb.ToDoItemEntity

interface ToDoListRepository {
    suspend fun getToDoListData(): List<ToDoItemEntity>
    suspend fun deleteToDoListItem(toDoItemEntity: ToDoItemEntity)
    suspend fun insertToDoListItem(toDoItemEntity: ToDoItemEntity)
    suspend fun updateToDoListItem(toDoItemEntity: ToDoItemEntity)
}