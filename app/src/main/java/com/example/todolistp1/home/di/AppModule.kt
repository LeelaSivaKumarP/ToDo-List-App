package com.example.todolistp1.home.di

import android.content.Context
import com.example.todolistp1.home.data.localdb.MyRoomDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideDB(@ApplicationContext context: Context): MyRoomDB {
        return MyRoomDB.getDataBase(context)
    }

    @Provides
    fun provideDao(db: MyRoomDB) = db.myDao()

}