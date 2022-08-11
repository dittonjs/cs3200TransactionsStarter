package com.usu.preferenceswithmvvm.ui.navigation

data class Screen(val route: String)

object Routes {
    val home = Screen("home")
    val preferences = Screen("preferences")
}