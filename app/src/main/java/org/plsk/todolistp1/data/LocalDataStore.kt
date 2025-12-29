package org.plsk.todolistp1.data

import org.plsk.todolistp1.data.localdb.ToDoItemDBModel
import kotlinx.coroutines.flow.Flow

interface LocalDataStore {
    suspend fun insertData(toDoItemDBModel: ToDoItemDBModel): Int
    suspend fun fetchData(): Flow<List<ToDoItemDBModel>>
    suspend fun getToDoItem(id: Int): ToDoItemDBModel?
    suspend fun deleteData(toDoItemDBModel: ToDoItemDBModel): Int
    suspend fun updateData(toDoItemDBModel: ToDoItemDBModel): Int
}