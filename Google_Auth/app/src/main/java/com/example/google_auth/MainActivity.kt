package com.example.google_auth


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.google.firebase.auth.FirebaseAuth
import ui.LoginScreen
import ui.ProfileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var loggedIn by remember {
                mutableStateOf(FirebaseAuth.getInstance().currentUser != null)
            }

            if (loggedIn) {
                ProfileScreen {
                    loggedIn = false
                }
            } else {
                LoginScreen {
                    loggedIn = true
                }
            }
        }
    }
}
