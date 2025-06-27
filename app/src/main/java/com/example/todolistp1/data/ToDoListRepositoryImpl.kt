package com.example.todolistp1.data

import com.example.todolistp1.data.localdb.ToDoItemDBModel
import com.example.todolistp1.domain.ToDoListRepository
import javax.inject.Inject

class ToDoListRepositoryImpl @Inject constructor(val localDataStore: LocalDataStore) :
    ToDoListRepository {

    override suspend fun getToDoListData() = localDataStore.fetchData()

    override suspend fun getToDoListItem(id: Int) = localDataStore.getToDoItem(id)

    override suspend fun deleteToDoListItem(toDoItemDBModel: ToDoItemDBModel): Int {
        return localDataStore.deleteData(toDoItemDBModel)
    }

    override suspend fun insertToDoListItem(toDoItemDBModel: ToDoItemDBModel): Int {
        return localDataStore.insertData(toDoItemDBModel)
    }

    override suspend fun updateToDoListItem(toDoItemDBModel: ToDoItemDBModel): Int {
        return localDataStore.updateData(toDoItemDBModel)
    }
}