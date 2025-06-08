package com.example.todolistp1.home.domain

interface LocalDataStore {
    suspend fun insertData()
    suspend fun fetchData()
    suspend fun deleteData()
    suspend fun updateData()
}