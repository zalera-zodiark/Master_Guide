package com.charros_software.master_guide.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.charros_software.master_guide.screens.MainMenuScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.MainMenuScreen.route) {
        composable(route = AppScreens.MainMenuScreen.route) { MainMenuScreen(navController)}
    }
}