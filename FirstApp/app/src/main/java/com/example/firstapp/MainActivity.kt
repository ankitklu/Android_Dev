package com.example.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstapp.ui.theme.FirstAppTheme

import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment

import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.background



class MainActivity : ComponentActivity() {
    // This is called when the activity is called,
    // It is used to Initialize the UI , Load Data, Setup Navigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //This is used for modern full screen apps, Transparent status bars and Immersive UI
        enableEdgeToEdge()  // Allow UI to draw behind system bars

        setContent {

            //Central part to do the styling and all, where we can apply colors, typography, Dark/light mode
            // central place for styling
            FirstAppTheme {

                // it provides bottom floating action button, top app bar, Bottom Navigation, Snackbar support
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding) // passign thre UI behaviour
                    )
                }
            }
        }
    }
}

// @Composable annotaiton -> Marks this funtion as UI , Can display UI , react to state and recompose automatically.
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val backgroundColor = remember {
        mutableStateOf(Color.White)
    }

    Column(
        modifier = modifier.fillMaxSize().background(backgroundColor.value),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hello Ankit!")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                backgroundColor.value = Color(0xFFFFC107)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6200EE), // background color
                contentColor = Color.White          // text color
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Hot")
        }

        Button(
            onClick = {
                backgroundColor.value = Color(0xFFBBDEFB)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6200EE), // background color
                contentColor = Color.White          // text color
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Cool")
        }

    }
}



// GreetingPreview() function is never called in the MainActivity.kt file but Android studion internally calls this.
@Preview(showBackground = true)  // This annotation shows UI in android studio Preview where no emulator is needed and UI iteration are faster
@Composable
fun GreetingPreview() {
    FirstAppTheme {
        Greeting("Android")
    }
}