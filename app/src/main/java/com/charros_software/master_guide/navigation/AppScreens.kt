package com.charros_software.master_guide.navigation

sealed class AppScreens(val route: String) {
    object MainMenuScreen: AppScreens("main_menu_screen")
}