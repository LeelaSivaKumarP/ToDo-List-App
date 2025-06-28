package org.plsk.todolistp1.data

import org.plsk.todolistp1.data.localdb.MyDao
import org.plsk.todolistp1.data.localdb.ToDoItemDBModel
import javax.inject.Inject

class LocalDataStoreImpl @Inject constructor(val myDao: MyDao) : LocalDataStore {

    override suspend fun insertData(toDoItemDBModel: ToDoItemDBModel): Int {
        myDao.addToDB(toDoItemDBModel)
        return 1
    }

    override suspend fun fetchData() = myDao.fetchFromDB()

    override suspend fun getToDoItem(id: Int) = myDao.getToDoItem(id)

    override suspend fun updateData(toDoItemDBModel: ToDoItemDBModel): Int {
        myDao.addToDB(toDoItemDBModel)
        return 1
    }

    override suspend fun deleteData(toDoItemDBModel: ToDoItemDBModel): Int {
        return myDao.deleteFromDB(toDoItemDBModel.id)
    }
}