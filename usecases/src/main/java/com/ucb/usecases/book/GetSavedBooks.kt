package com.ucb.usecases.book

import com.ucb.data.book.BookRepository
import com.ucb.domain.Book

class GetSavedBooks(
    private val bookRepository: BookRepository,
) {
    suspend fun invoke(): List<Book> = bookRepository.getSavedBooks()
}
