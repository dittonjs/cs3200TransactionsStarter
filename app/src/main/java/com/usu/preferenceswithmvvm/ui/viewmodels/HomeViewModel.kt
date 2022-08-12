package com.usu.preferenceswithmvvm.ui.viewmodels

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.usu.preferenceswithmvvm.ui.screens.Transaction

class HomeScreenState {
    private val _transactions = mutableStateListOf<Transaction>(
        Transaction(45.01, "Barnes and Noble", 111234323, "Books for school"),
        Transaction(25.98, "Domino's Pizza", 132399439, "Pizza for dinner"),
        Transaction(377.54, "Logan City", 12388328, "Electric bill"),
        Transaction(2212.23, "Rocket Mortgage", 12384324, "Mortage payment"),
    )
    var showEntityName by mutableStateOf(false)
    var showEntityId by mutableStateOf(false)
    var showPurpose by mutableStateOf(false)
    var loading by mutableStateOf(true)
    val transactions: List<Transaction> get() = _transactions
}

class HomeViewModel(application: Application): AndroidViewModel(application){
    val uiState = HomeScreenState()
    private val sharedPreferences: SharedPreferences
    init {
        println("I GOT CREATED")
        sharedPreferences = application.getSharedPreferences("default", Context.MODE_PRIVATE)
    }

    fun loadPreferences() {
        uiState.showEntityName = sharedPreferences.getBoolean("showEntityName", true)
        uiState.showEntityId = sharedPreferences.getBoolean("showEntityId", true)
        uiState.showPurpose = sharedPreferences.getBoolean("showPurpose", true)
        uiState.loading = false
    }
}