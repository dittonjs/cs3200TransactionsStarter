package com.usu.preferenceswithmvvm.ui.viewmodels

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.AbstractApplier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel

class PreferencesScreenState {
    var showEntityName by mutableStateOf(false)
    var showEntityId by mutableStateOf(false)
    var showPurpose by mutableStateOf(false)
    var loading by mutableStateOf(true)
}

class PreferencesViewModel(application: Application): AndroidViewModel(application){
    val uiState = PreferencesScreenState()
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

    fun setPreference(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
        when(key) {
            "showEntityName" -> uiState.showEntityName = value
            "showEntityId" -> uiState.showEntityId = value
            "showPurpose" -> uiState.showPurpose = value
        }
    }
}