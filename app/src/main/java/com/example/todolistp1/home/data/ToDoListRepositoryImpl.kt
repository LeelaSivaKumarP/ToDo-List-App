package com.example.todolistp1.home.data

import com.example.todolistp1.home.data.localdb.ToDoItemDBModel
import com.example.todolistp1.home.domain.ToDoListRepository
import javax.inject.Inject

class ToDoListRepositoryImpl @Inject constructor(val localDataStoreImpl: LocalDataStore): ToDoListRepository {

    override suspend fun getToDoListData() = localDataStoreImpl.fetchData()

    override suspend fun deleteToDoListItem(toDoItemDBModel: ToDoItemDBModel): Int {
        return localDataStoreImpl.deleteData(toDoItemDBModel)
    }

    override suspend fun insertToDoListItem(toDoItemDBModel: ToDoItemDBModel): Int {
        return localDataStoreImpl.insertData(toDoItemDBModel)
    }

    override suspend fun updateToDoListItem(toDoItemDBModel: ToDoItemDBModel): Int {
        return localDataStoreImpl.updateData(toDoItemDBModel)
    }
}