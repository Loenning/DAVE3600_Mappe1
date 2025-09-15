package com.example.mappe1.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mappe1.ui.screens.GameScreen
import com.example.mappe1.ui.screens.IntroScreen

object AppRoutes{
    const val INTRO_SCREEN = "intro"
    const val GAME_SCREEN = "game"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppRoutes.INTRO_SCREEN) {

        composable(route = AppRoutes.INTRO_SCREEN) {
            IntroScreen(
                onStartGameClick = {navController.navigate(AppRoutes.GAME_SCREEN)},
                onAboutGameClick = {},
                onPreferencesClick = {}
            )
        }

        composable(route = AppRoutes.GAME_SCREEN) {
            GameScreen(
                onClickCancelGame = {/*TODO*/}
            )
        }
    }
}