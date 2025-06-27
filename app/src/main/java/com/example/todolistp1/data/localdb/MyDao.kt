package com.example.todolistp1.data.localdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MyDao {
    @Insert(onConflict = REPLACE)
    suspend fun addToDB(toDoItemDBModel: ToDoItemDBModel)

    @Query("Delete from todo_items where id=:id")
    suspend fun deleteFromDB(id: Int): Int

    @Query("Select * from todo_items")
    fun fetchFromDB(): Flow<List<ToDoItemDBModel>>

    @Query("Select * from todo_items where id=:id")
    suspend fun getToDoItem(id: Int): ToDoItemDBModel
}