package com.ucb.usecases.book

import com.ucb.data.book.BookRepository
import com.ucb.domain.Book

class SaveBook(
    private val bookRepository: BookRepository,
) {
    suspend fun invoke(book: Book) = bookRepository.saveBook(book)
}
