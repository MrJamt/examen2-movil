package com.ucb.ucbtest.book

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucb.domain.Book
import com.ucb.usecases.book.GetSavedBooks
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedBooksViewModel
    @Inject
    constructor(
        private val getSavedBooks: GetSavedBooks,
    ) : ViewModel() {
        private val _state = MutableLiveData<List<Book>>()
        val state: LiveData<List<Book>> = _state

        fun getSavedBooks() {
            viewModelScope.launch {
                _state.value = getSavedBooks.invoke()
            }
        }
    }
