package com.ucb.ucbtest.navigation

sealed class Screen(
    val route: String,
) {
    object BookScreen : Screen("book_screen")

    object SavedBooksScreen : Screen("saved_books_screen")

    object HomeUIScreen : Screen("home_ui_screen")
}
