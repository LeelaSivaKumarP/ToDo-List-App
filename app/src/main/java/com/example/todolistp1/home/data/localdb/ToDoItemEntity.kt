package com.example.todolistp1.home.data.localdb

import androidx.room.PrimaryKey

data class ToDoItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var isChecked: Boolean,
    val title: String,
    var dateTime: String? = null,
    var repeatMode: Boolean = false,
    var category: String? = null
)
