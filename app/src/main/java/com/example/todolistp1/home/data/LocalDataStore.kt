package com.example.todolistp1.home.data

import com.example.todolistp1.home.data.localdb.ToDoItemDBModel

interface LocalDataStore {
    suspend fun insertData(toDoItemDBModel: ToDoItemDBModel): Int
    suspend fun fetchData(): List<ToDoItemDBModel>
    suspend fun deleteData(toDoItemDBModel: ToDoItemDBModel): Int
    suspend fun updateData(toDoItemDBModel: ToDoItemDBModel): Int
}