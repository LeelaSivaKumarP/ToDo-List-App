package com.example.todolistp1.home.data.localdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ToDoItemEntity::class], version = 1)
abstract class MyRoomDB: RoomDatabase() {

    companion object {
        fun getDataBase(context: Context): MyRoomDB {
            return Room.databaseBuilder(context, MyRoomDB::class.java, "MYDB").build()
        }
    }
    abstract fun myDao(): MyDao
}