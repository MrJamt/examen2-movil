@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.ucb.ucbtest.book

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ucb.domain.Book

@Suppress("ktlint:standard:function-naming")
@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun BookUI(bookViewModel: BookViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val state = bookViewModel.state.value
    val (query, setQuery) = remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Search Books", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = query,
            onValueChange = setQuery,
            label = { Text("Enter book title") },
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (query.isNotBlank()) {
                    bookViewModel.searchBooks(query)
                } else {
                    Toast.makeText(context, "Please enter a query", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Search")
        }

        Spacer(modifier = Modifier.height(24.dp))

        when (state) {
            is BookViewModel.BookUIState.Loading -> {
                CircularProgressIndicator()
            }

            is BookViewModel.BookUIState.Loaded -> {
                BookList(books = state.books) { book ->
                    bookViewModel.saveBook(book)
                    Toast.makeText(context, "Book saved", Toast.LENGTH_SHORT).show()
                }
            }

            is BookViewModel.BookUIState.Error -> {
                Text("Error: ${state.message}", color = MaterialTheme.colorScheme.error)
            }
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun BookList(
    books: List<Book>,
    onSave: (Book) -> Unit,
) {
    Column {
        books.forEach { book ->
            ElevatedCard(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable { /* Optional: Show details */ },
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column {
                        Text(book.title, style = MaterialTheme.typography.titleMedium)
                        Text("By: ${book.authors.joinToString(", ")}")
                        Text("Published: ${book.publishYear}")
                    }
                    IconButton(onClick = { onSave(book) }) {
                        Icon(Icons.Filled.Favorite, contentDescription = "Save")
                    }
                }
            }
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Preview(showBackground = true)
@Composable
fun BookUIPreview() {
    BookUI()
}
