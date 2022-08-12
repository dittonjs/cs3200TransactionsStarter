package com.usu.preferenceswithmvvm.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.usu.preferenceswithmvvm.ui.components.TransactionListItem
import com.usu.preferenceswithmvvm.ui.viewmodels.HomeViewModel

data class Transaction(val amount: Double, val entityName: String, val entityId: Long, val purpose: String)

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel: HomeViewModel = viewModel()
    val state = viewModel.uiState
    LaunchedEffect(true) {
        viewModel.loadPreferences()
    }
    if (state.loading) return
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        items(state.transactions) {
            TransactionListItem(
                transaction = it,
                showEntityName = state.showEntityName,
                showEntityId = state.showEntityId,
                showPurpose = state.showPurpose
            )
        }
    }
}