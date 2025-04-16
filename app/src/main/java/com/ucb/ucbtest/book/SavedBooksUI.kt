@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.ucb.ucbtest.book

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Suppress("ktlint:standard:function-naming")
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SavedBooksUI(viewModel: SavedBooksViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val books = viewModel.state.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.getSavedBooks()
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Text("Libros Guardados", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { viewModel.getSavedBooks() },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Actualizar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (books.isEmpty()) {
            Text("No hay libros guardados.")
        } else {
            BookList(
                books = books,
                onSave = { book ->
                    Toast.makeText(context, "Libro guardado en favoritos!", Toast.LENGTH_SHORT).show()
                },
                showHeart = false,
            )
        }
    }
}
