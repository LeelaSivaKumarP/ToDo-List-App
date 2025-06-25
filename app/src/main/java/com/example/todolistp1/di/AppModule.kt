package com.example.todolistp1.di

import android.content.Context
import com.example.todolistp1.data.LocalDataStore
import com.example.todolistp1.data.LocalDataStoreImpl
import com.example.todolistp1.data.ToDoListRepositoryImpl
import com.example.todolistp1.data.localdb.MyRoomDB
import com.example.todolistp1.domain.ToDoListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideDB(@ApplicationContext context: Context): MyRoomDB {
        return MyRoomDB.getDataBase(context)
    }

    @Singleton
    @Provides
    fun provideDao(db: MyRoomDB) = db.myDao()

    @Singleton
    @Provides
    fun provideLocalDataStore(localDataStoreImpl: LocalDataStoreImpl): LocalDataStore =
        localDataStoreImpl

    @Singleton
    @Provides
    fun provideToDoListRepository(toDoListRepositoryImpl: ToDoListRepositoryImpl): ToDoListRepository =
        toDoListRepositoryImpl

}