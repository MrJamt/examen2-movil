
@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.ucb.ucbtest.book

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ucb.domain.Book
import com.ucb.ucbtest.navigation.Screen

@Suppress("ktlint:standard:function-naming")
@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun BookUI(
    bookViewModel: BookViewModel = hiltViewModel(),
    navController: NavController,
) {
    val context = LocalContext.current
    val state = bookViewModel.state.value
    val (query, setQuery) = remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth(),
        ) {
            IconButton(onClick = {
                navController.navigate(Screen.SavedBooksScreen.route)
            }) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Favoritos",
                    tint = MaterialTheme.colorScheme.primary,
                )
            }
        }

        Text(text = "Buscar Libros", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = query,
            onValueChange = setQuery,
            label = { Text("Ingresa el titulo de un libro") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions =
                KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search,
                ),
            keyboardActions =
                KeyboardActions(
                    onSearch = {
                        focusManager.clearFocus()
                        if (query.isNotBlank()) {
                            bookViewModel.searchBooks(query)
                        } else {
                            Toast.makeText(context, "Por favor ingresa el titulo de un libro", Toast.LENGTH_SHORT).show()
                        }
                    },
                ),
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (query.isNotBlank()) {
                    bookViewModel.searchBooks(query)
                } else {
                    Toast.makeText(context, "Por favor ingresa el titulo de un libro", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Buscar")
        }

        Spacer(modifier = Modifier.height(24.dp))

        when (state) {
            is BookViewModel.BookUIState.Loading -> {
                CircularProgressIndicator()
            }

            is BookViewModel.BookUIState.Loaded -> {
                BookList(
                    books = state.books,
                    onSave = { book ->
                        bookViewModel.saveBook(book)
                        Toast.makeText(context, "Libro guardado en favoritos!", Toast.LENGTH_SHORT).show()
                    },
                )
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
    showHeart: Boolean = true,
) {
    Column {
        books.forEach { book ->
            ElevatedCard(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column {
                        Text(book.title, style = MaterialTheme.typography.titleMedium)
                        Text("Por: ${book.authors.joinToString(", ")}")
                        Text("Publicado: ${book.publishYear}")
                    }
                    if (showHeart) {
                        IconButton(onClick = { onSave(book) }) {
                            Icon(Icons.Filled.Favorite, contentDescription = "Guardar")
                        }
                    }
                }
            }
        }
    }
}
