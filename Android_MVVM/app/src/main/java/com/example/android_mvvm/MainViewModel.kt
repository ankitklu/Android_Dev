package com.example.android_mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            delay(10000)

            val success = true   // change to false to test Error

            if (success) {
                _uiState.value = UiState.Success("Hello from ViewModel!")
            } else {
                _uiState.value = UiState.Error("Something went wrong 😢")
            }
        }
    }
}
