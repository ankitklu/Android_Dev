package com.example.android_mvvm

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.android_mvvm.MainViewModel
import com.example.android_mvvm.UiState
import androidx.compose.runtime.collectAsState


class MainActivity : ComponentActivity() {

    private val TAG = "Ankit"

    private val viewModel: MainViewModel by viewModels() // android will provide the viewModel instance that will handle ifecycle safety and survives config changes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"Line 24, After onCreate")
        setContent {
            val state = viewModel.uiState.collectAsState() // collectAsState() -> converts it into Compose-friendly state
            Log.d(TAG,"Line 27, viewModel collectAsState()")
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                when (val ui = state.value) {

                    is UiState.Loading -> {
                        CircularProgressIndicator()
                        Log.d(TAG,"Line 36 Load bar shown")
                    }

                    is UiState.Success -> {
                        Text(text = ui.data)
                        Log.d(TAG,"Line 41, Success data")
                    }

                    is UiState.Error -> {
                        Text(text = ui.message)
                        Log.d(TAG,"Line 46, Error loading the data")
                    }
                }
            }
        }
    }
}
