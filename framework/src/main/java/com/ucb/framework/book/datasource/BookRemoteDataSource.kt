package com.ucb.framework.book.datasource

import com.ucb.data.NetworkResult
import com.ucb.data.book.IBookRemoteDataSource
import com.ucb.domain.Book
import com.ucb.framework.book.mappers.toModel
import com.ucb.framework.service.RetrofitBuilder

class BookRemoteDataSource(
    val retrofiService: RetrofitBuilder,
) : IBookRemoteDataSource {
    override suspend fun searchBooks(query: String): NetworkResult<List<Book>> {
        val response = retrofiService.bookService.searchBooks(query)
        if (response.isSuccessful) {
            return NetworkResult.Success(response.body()!!.results.map { it.toModel() })
        } else {
            return NetworkResult.Error(response.message())
        }
    }
}
