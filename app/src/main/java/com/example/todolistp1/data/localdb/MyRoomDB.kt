package com.example.todolistp1.data.localdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ToDoItemDBModel::class], version = 1, exportSchema = false)
abstract class MyRoomDB : RoomDatabase() {

    companion object {
        val DB_NAME = "MYDB"
        fun getDataBase(context: Context): MyRoomDB {
            return Room.databaseBuilder(context, MyRoomDB::class.java, DB_NAME).build()
        }
    }

    abstract fun myDao(): MyDao
}