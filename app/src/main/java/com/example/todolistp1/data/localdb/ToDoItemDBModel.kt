package com.example.todolistp1.data.localdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_items")
data class ToDoItemDBModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var isChecked: Boolean,
    val title: String,
    var dateTime: String? = null,
    var repeatMode: Boolean = false,
    var category: String? = null
)
