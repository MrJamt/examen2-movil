package com.ucb.framework.book.mappers

import com.ucb.domain.Book
import com.ucb.framework.book.entity.BookEntity

fun Book.toEntity(): BookEntity =
    BookEntity(
        title = this.title,
        authors = this.authors.toString(),
        publishYear = this.publishYear,
    )

fun BookEntity.toModel(): Book =
    Book(
        title = this.title,
        authors = this.authors.split(",").map { it.trim() },
        publishYear = this.publishYear,
    )
