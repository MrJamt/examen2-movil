package com.ucb.ucbtest.di

import android.content.Context
import com.ucb.data.book.BookRepository
import com.ucb.data.book.IBookLocalDataSource
import com.ucb.data.book.IBookRemoteDataSource
import com.ucb.data.plan.IPlanLocalDataSource
import com.ucb.data.plan.PlanRepository
import com.ucb.framework.book.datasource.BookLocalDataSource
import com.ucb.framework.book.datasource.BookRemoteDataSource
import com.ucb.framework.plan.datasource.PlanRemoteDataSource
import com.ucb.framework.service.RetrofitBuilder
import com.ucb.usecases.book.GetSavedBooks
import com.ucb.usecases.book.SaveBook
import com.ucb.usecases.book.SearchBooks
import com.ucb.usecases.plan.GetPlans
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providerRetrofitBuilder(
        @ApplicationContext context: Context,
    ): RetrofitBuilder = RetrofitBuilder(context)

    @Provides
    @Singleton
    fun provideBookRemoteDataSource(retrofit: RetrofitBuilder): IBookRemoteDataSource = BookRemoteDataSource(retrofit)

    @Provides
    @Singleton
    fun provideBookLocalDataSource(
        @ApplicationContext context: Context,
    ): IBookLocalDataSource = BookLocalDataSource(context)

    @Provides
    @Singleton
    fun provideBookRepository(
        remoteDataSource: IBookRemoteDataSource,
        localDataSource: IBookLocalDataSource,
    ): BookRepository = BookRepository(remoteDataSource, localDataSource)

    @Provides
    @Singleton
    fun provideSearchBooks(bookRepository: BookRepository): SearchBooks = SearchBooks(bookRepository)

    @Provides
    @Singleton
    fun provideSaveBook(bookRepository: BookRepository): SaveBook = SaveBook(bookRepository)

    @Provides
    @Singleton
    fun provideGetSavedBooks(repository: BookRepository): GetSavedBooks = GetSavedBooks(repository)

    @Provides
    @Singleton
    fun providePlanLocalDataSource(
        @ApplicationContext context: Context,
    ): IPlanLocalDataSource = PlanRemoteDataSource(context)

    @Provides
    @Singleton
    fun providePlanRepository(localDataSource: IPlanLocalDataSource): PlanRepository = PlanRepository(localDataSource)

    @Provides
    @Singleton
    fun provideGetPlans(planRepository: PlanRepository): GetPlans = GetPlans(planRepository)
}
