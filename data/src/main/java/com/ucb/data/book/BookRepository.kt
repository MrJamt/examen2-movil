package com.ucb.data.book

import com.ucb.data.NetworkResult
import com.ucb.domain.Book

class BookRepository(
    private val bookRemoteDataSource: IBookRemoteDataSource,
    private val bookLocalDataSource: IBookLocalDataSource,
) {
    suspend fun searchBooks(query: String): NetworkResult<List<Book>> = bookRemoteDataSource.searchBooks(query)

    suspend fun saveBook(book: Book) {
        bookLocalDataSource.saveBook(book)
    }

    suspend fun getSavedBooks(): List<Book> = bookLocalDataSource.getSavedBooks()
}
