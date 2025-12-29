package com.example.android_mvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class ContactViewModel: ViewModel(){
    // we extend the ViewModel() class to preserve the state post configuration changes
    // in this case resolution change

    var backgroundColor by mutableStateOf(Color.White)
        private set;


    fun changeBackgroundColor(){
        backgroundColor = Color.Red
    }
}