package com.usu.preferenceswithmvvm.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.usu.preferenceswithmvvm.ui.components.PreferenceItem
import com.usu.preferenceswithmvvm.ui.viewmodels.PreferencesViewModel

@Composable
fun PreferencesScreen(navController: NavController) {
    val viewModel: PreferencesViewModel = viewModel()
    val state = viewModel.uiState
    LaunchedEffect(true) {
        viewModel.loadPreferences()
    }

    if (state.loading) {
        Text(text = "Loading...")
        return
    }
    Column {
        PreferenceItem(
            text = "Show entity name",
            isChecked = state.showEntityName,
            onChange = { viewModel.setPreference("showEntityName", it) }
        )
        Spacer(modifier = Modifier.padding(4.dp))
        PreferenceItem(
            text = "Show entity id",
            isChecked = state.showEntityId,
            onChange = {viewModel.setPreference("showEntityId", it)}
        )
        Spacer(modifier = Modifier.padding(4.dp))
        PreferenceItem(
            text = "Show transaction purpose",
            isChecked = state.showPurpose,
            onChange = {viewModel.setPreference("showPurpose", it)}
        )
    }
}