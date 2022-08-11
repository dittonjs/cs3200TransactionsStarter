package com.usu.preferenceswithmvvm.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.usu.preferenceswithmvvm.ui.components.PreferenceItem

@Composable
fun PreferencesScreen(navController: NavController) {
    Column {
        PreferenceItem(
            text = "Show entity name",
            isChecked = false,
            onChange = {}
        )
        Spacer(modifier = Modifier.padding(4.dp))
        PreferenceItem(
            text = "Show entity id",
            isChecked = false,
            onChange = {}
        )
        Spacer(modifier = Modifier.padding(4.dp))
        PreferenceItem(
            text = "Show transaction purpose",
            isChecked = false,
            onChange = {}
        )
    }
}