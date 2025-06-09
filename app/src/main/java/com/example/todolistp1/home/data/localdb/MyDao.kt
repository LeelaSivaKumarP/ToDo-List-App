package com.example.todolistp1.home.data.localdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

@Dao
interface MyDao {
    @Insert(onConflict = REPLACE)
    suspend fun addToDB(toDoItemDBModel: ToDoItemDBModel)

    @Query("Delete from todo_items where id=:id")
    suspend fun deleteFromDB(id: Int): Int

    @Query("Select * from todo_items")
    suspend fun fetchFromDB(): List<ToDoItemDBModel>
}