package com.example.todolistp1.data

import com.example.todolistp1.data.localdb.ToDoItemDBModel
import kotlinx.coroutines.flow.Flow

interface LocalDataStore {
    suspend fun insertData(toDoItemDBModel: ToDoItemDBModel): Int
    suspend fun fetchData(): Flow<List<ToDoItemDBModel>>
    suspend fun deleteData(toDoItemDBModel: ToDoItemDBModel): Int
    suspend fun updateData(toDoItemDBModel: ToDoItemDBModel): Int
}