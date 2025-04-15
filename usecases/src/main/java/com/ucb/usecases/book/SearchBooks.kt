package com.ucb.usecases.book

import com.ucb.data.NetworkResult
import com.ucb.data.book.BookRepository
import com.ucb.domain.Book

class SearchBooks(
    private val bookRepository: BookRepository,
) {
    suspend fun invoke(query: String): NetworkResult<List<Book>> = bookRepository.searchBooks(query)
}
