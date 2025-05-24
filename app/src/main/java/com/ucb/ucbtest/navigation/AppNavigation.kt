package com.ucb.ucbtest.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ucb.ucbtest.book.BookUI
import com.ucb.ucbtest.book.SavedBooksUI
import com.ucb.ucbtest.plan.HomeUI
import com.ucb.ucbtest.sendSIMUI.SendSimUI

@Suppress("ktlint:standard:function-naming")
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.HomeUIScreen.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
    ) {
        composable(Screen.BookScreen.route) {
            BookUI(navController = navController)
        }

        composable(Screen.HomeUIScreen.route) {
            HomeUI(navController = navController)
        }

        composable(Screen.SendSimUI.route) {
            SendSimUI(navController = navController)
        }

        composable(Screen.SavedBooksScreen.route) {
            SavedBooksUI()
        }
    }
}
