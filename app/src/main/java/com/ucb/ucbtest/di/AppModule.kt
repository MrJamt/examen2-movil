package com.ucb.ucbtest.di

import android.content.Context
import com.ucb.data.GithubRepository
import com.ucb.data.book.BookRepository
import com.ucb.data.book.IBookLocalDataSource
import com.ucb.data.book.IBookRemoteDataSource
import com.ucb.data.git.IGitRemoteDataSource
import com.ucb.data.git.ILocalDataSource
import com.ucb.framework.book.datasource.BookLocalDataSource
import com.ucb.framework.book.datasource.BookRemoteDataSource
import com.ucb.framework.github.GithubLocalDataSource
import com.ucb.framework.github.GithubRemoteDataSource
import com.ucb.framework.service.RetrofitBuilder
import com.ucb.usecases.FindGitAlias
import com.ucb.usecases.SaveGitalias
import com.ucb.usecases.book.GetSavedBooks
import com.ucb.usecases.book.SaveBook
import com.ucb.usecases.book.SearchBooks
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
    fun gitRemoteDataSource(retrofiService: RetrofitBuilder): IGitRemoteDataSource = GithubRemoteDataSource(retrofiService)

    @Provides
    @Singleton
    fun provideLocalDataSource(
        @ApplicationContext context: Context,
    ): ILocalDataSource = GithubLocalDataSource(context)

    @Provides
    @Singleton
    fun gitRepository(
        remoteDataSource: IGitRemoteDataSource,
        localDataSource: ILocalDataSource,
    ): GithubRepository = GithubRepository(remoteDataSource, localDataSource)

    @Provides
    @Singleton
    fun provideSaveGitAlias(repository: GithubRepository): SaveGitalias = SaveGitalias(repository)

    @Provides
    @Singleton
    fun provideGitUseCases(githubRepository: GithubRepository): FindGitAlias = FindGitAlias(githubRepository)

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
        localDataSource: IBookLocalDataSource
    ): BookRepository {
        return BookRepository(remoteDataSource, localDataSource)
    }

    @Provides
    @Singleton
    fun provideSearchBooks(bookRepository: BookRepository): SearchBooks {
        return SearchBooks(bookRepository)
    }

    @Provides
    @Singleton
    fun provideSaveBook(bookRepository: BookRepository): SaveBook {
        return SaveBook(bookRepository)
    }

    @Provides
    @Singleton
    fun provideGetSavedBooks(repository: BookRepository): GetSavedBooks {
        return GetSavedBooks(repository)
    }
}
