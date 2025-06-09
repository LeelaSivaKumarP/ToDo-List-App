package com.example.todolistp1.di

import com.example.todolistp1.home.domain.usecase.AddToDoItemUseCaseImpl
import com.example.todolistp1.home.domain.usecase.DeleteToDoListUseCaseImpl
import com.example.todolistp1.home.domain.usecase.FetchToDoDataUseCaseImpl
import com.example.todolistp1.home.domain.usecase.ModifyToDoDataUseCaseImpl
import com.example.todolistp1.home.presentation.usecase.AddToDoItemUseCase
import com.example.todolistp1.home.presentation.usecase.DeleteToDoDataUseCase
import com.example.todolistp1.home.presentation.usecase.FetchToDoDataUseCase
import com.example.todolistp1.home.presentation.usecase.ModifyToDoDataUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Suppress("unused")
@InstallIn(ViewModelComponent::class)
@Module
abstract class ViewModuleModule {

    @Binds
    abstract fun provideAddToDoItemUseCase(addToDoItemUseCaseImpl: AddToDoItemUseCaseImpl): AddToDoItemUseCase

    @Binds
    abstract fun providesDeleteToDoItemUSeCase(deleteToDoItemUseCaseImpl: DeleteToDoListUseCaseImpl): DeleteToDoDataUseCase

    @Binds
    abstract fun providesModifyToDoDataUseCase(modifyToDoDataUseCaseImpl: ModifyToDoDataUseCaseImpl): ModifyToDoDataUseCase

    @Binds
    abstract fun providesFetchToDoItemUSeCase(fetchToDoDataUseCaseImpl: FetchToDoDataUseCaseImpl): FetchToDoDataUseCase
}