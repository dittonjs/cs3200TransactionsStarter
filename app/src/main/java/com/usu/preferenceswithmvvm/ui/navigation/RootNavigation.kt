package com.usu.preferenceswithmvvm.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.usu.preferenceswithmvvm.ui.screens.HomeScreen
import com.usu.preferenceswithmvvm.ui.screens.PreferencesScreen


@Composable
fun RootNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.home.route) {
        composable(Routes.home.route) { HomeScreen(navController = navController)}
        composable(Routes.preferences.route) { PreferencesScreen(navController = navController) }
    }
}