package com.usu.preferenceswithmvvm.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Applier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.usu.preferenceswithmvvm.ui.navigation.RootNavigation
import com.usu.preferenceswithmvvm.ui.navigation.Routes
import com.usu.preferenceswithmvvm.ui.theme.PreferencesWithMVVMTheme

@Composable
fun App() {
    PreferencesWithMVVMTheme {
        val navController = rememberNavController()
        Scaffold(
            topBar = {
                TopAppBar() {
                    Text(text = "MVVM Preferences")
                }
            },
            bottomBar = {
                BottomNavigation {
                    val backStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = backStackEntry?.destination
                    BottomNavigationItem(
                        selected = currentRoute?.hierarchy?.any { it.route == Routes.home.route} ?: false,
                        onClick = {
                            navController.navigate(Routes.home.route){
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(Icons.Default.Home, contentDescription = "Home Page")
                        }
                    )
                    BottomNavigationItem(
                        selected = currentRoute?.hierarchy?.any { it.route == Routes.preferences.route} ?: false,
                        onClick = {
                            navController.navigate(Routes.preferences.route){
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(Icons.Default.Settings, contentDescription = "Settings Page")
                        }
                    )
                }
            }
        ) {
            Box(modifier = Modifier.padding(it)) {
                RootNavigation(navController = navController)
            }
        }
    }
}