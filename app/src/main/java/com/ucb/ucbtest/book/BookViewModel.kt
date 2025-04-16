package com.ucb.ucbtest.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucb.data.NetworkResult
import com.ucb.domain.Book
import com.ucb.usecases.book.SaveBook
import com.ucb.usecases.book.SearchBooks
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel
    @Inject
    constructor(
        private val searchBooks: SearchBooks,
        private val saveBook: SaveBook,
    ) : ViewModel() {
        sealed class BookUIState {
            object Loading : BookUIState()

            class Loaded(
                val books: List<Book>,
            ) : BookUIState()

            class Error(
                val message: String,
            ) : BookUIState()
        }

        private val _state = MutableStateFlow<BookUIState>(BookUIState.Loading)
        val state: StateFlow<BookUIState> = _state

        fun searchBooks(query: String) {
            _state.value = BookUIState.Loading
            viewModelScope.launch {
                try {
                    val result = searchBooks.invoke(query)
                    when (result) {
                        is NetworkResult.Error -> {
                            _state.value = BookUIState.Error(result.error)
                        }
                        is NetworkResult.Success -> {
                            _state.value = BookUIState.Loaded(result.data)
                        }
                    }
                } catch (e: Exception) {
                    _state.value = BookUIState.Error("Error inesperado: ${e.message}")
                }
            }
        }

        fun saveBook(book: Book) {
            viewModelScope.launch {
                try {
                    saveBook.invoke(book)
                } catch (e: Exception) {
                    println("Error al guardar el libro: ${e.message}")
                }
            }
        }
    }
