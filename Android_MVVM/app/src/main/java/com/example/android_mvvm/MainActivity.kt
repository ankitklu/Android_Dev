package com.example.android_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.android_mvvm.ui.theme.Android_MVVMTheme

class MainActivity : ComponentActivity() {


    // this is necessary because in Android A resolution change is considered a configuration change
    // which will create the instance of ContactViewModel again.
    // to prevent this we code it as private val viewModel by viewModels<ContactViewModel>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val viewModel = viewModel<ContactViewModel>()
            // this is the compose way of using viewModel
            // we write this in the build.gradle file
            // implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")

            Android_MVVMTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = viewModel.backgroundColor
                ) {
                    Button(
                        modifier = Modifier.width(13.dp),
                        onClick = {viewModel.changeBackgroundColor()}
                    ) {
                        Text("Click to change color")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Android_MVVMTheme {
        Greeting("Android")
    }
}