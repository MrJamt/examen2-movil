package com.ucb.ucbtest.navigation

sealed class Screen(
    val route: String,
) {
    object HomeUIScreen : Screen("home_ui_screen")

    object SendSimUI : Screen("send_sim_ui")
}
