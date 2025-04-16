package com.ucb.framework.book.datasource

import android.content.Context
import com.ucb.data.book.IBookLocalDataSource
import com.ucb.domain.Book
import com.ucb.framework.book.mappers.toEntity
import com.ucb.framework.book.mappers.toModel
import com.ucb.framework.book.room.AppDatabase
import com.ucb.framework.local.dao.BookDao

class BookLocalDataSource(
    val context: Context,
) : IBookLocalDataSource {
    val bookDao: BookDao = AppDatabase.getDatabase(context).bookDao()

    override suspend fun saveBook(book: Book) {
        bookDao.insert(book.toEntity())
    }

    override suspend fun getSavedBooks(): List<Book> = bookDao.getAll().map { it.toModel() }
}
