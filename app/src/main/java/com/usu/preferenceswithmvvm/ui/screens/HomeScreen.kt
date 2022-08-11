package com.usu.preferenceswithmvvm.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.usu.preferenceswithmvvm.ui.components.TransactionListItem

data class Transaction(val amount: Double, val entityName: String, val entityId: Long, val purpose: String)

class HomeScreenState {
    private val _transactions = mutableStateListOf<Transaction>(
        Transaction(45.01, "Barnes and Noble", 111234323, "Books for school"),
        Transaction(25.98, "Domino's Pizza", 132399439, "Pizza for dinner"),
        Transaction(377.54, "Logan City", 12388328, "Electric bill"),
        Transaction(2212.23, "Rocket Mortgage", 12384324, "Mortage payment"),
    )

    val transactions: List<Transaction> get() = _transactions
}

@Composable
fun rememberHomeScreenState(): HomeScreenState {
    return remember { HomeScreenState() }
}

@Composable
fun HomeScreen(navController: NavController) {
    val state = rememberHomeScreenState()
    LazyColumn(
        modifier = Modifier.padding(16.dp).fillMaxSize()
    ) {
        items(state.transactions) {
            TransactionListItem(transaction = it)
        }
    }
}