package org.plsk.todolistp1.di

import org.plsk.todolistp1.domain.usecase.AddToDoItemUseCaseImpl
import org.plsk.todolistp1.domain.usecase.DeleteToDoListUseCaseImpl
import org.plsk.todolistp1.domain.usecase.FetchToDoDataUseCaseImpl
import org.plsk.todolistp1.domain.usecase.GetToDoItemByIDUseCaseImpl
import org.plsk.todolistp1.domain.usecase.ModifyToDoDataUseCaseImpl
import org.plsk.todolistp1.presentation.usecase.AddToDoItemUseCase
import org.plsk.todolistp1.presentation.usecase.DeleteToDoDataUseCase
import org.plsk.todolistp1.presentation.usecase.FetchToDoDataUseCase
import org.plsk.todolistp1.presentation.usecase.GetToDoItemByIDUseCase
import org.plsk.todolistp1.presentation.usecase.UpdateToDoDataUseCase
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
    abstract fun providesModifyToDoDataUseCase(modifyToDoDataUseCaseImpl: ModifyToDoDataUseCaseImpl): UpdateToDoDataUseCase

    @Binds
    abstract fun providesFetchToDoItemUSeCase(fetchToDoDataUseCaseImpl: FetchToDoDataUseCaseImpl): FetchToDoDataUseCase

    @Binds
    abstract fun provideGetItemByIDUseCase(getToDoItemByIDUseCaseImpl: GetToDoItemByIDUseCaseImpl): GetToDoItemByIDUseCase
}