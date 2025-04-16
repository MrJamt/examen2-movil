package com.ucb.ucbtest.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucb.domain.Book
import com.ucb.usecases.book.GetSavedBooks
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedBooksViewModel
    @Inject
    constructor(
        private val getSavedBooks: GetSavedBooks,
    ) : ViewModel() {
        private val _state = MutableStateFlow<List<Book>>(emptyList())
        val state: StateFlow<List<Book>> = _state

        fun getSavedBooks() {
            viewModelScope.launch {
                val savedBooks = getSavedBooks.invoke()
                _state.value = savedBooks
            }
        }
    }
