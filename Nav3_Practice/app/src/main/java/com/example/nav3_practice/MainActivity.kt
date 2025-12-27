package com.example.nav3_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nav3_practice.ui.theme.Nav3_PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigation()
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

@Composable
fun HomeScreen(onNavigate: () -> Unit) {
    Button(onClick = onNavigate) {
        Text("Go to Details")
    }
}

@Composable
fun DetailScreen(navController: NavHostController) {
    Column {
        Button(onClick = { navController.popBackStack() }) {
            Text("Back")
        }
        Text("This is the Detail Screen")
    }
}

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(
                onNavigate = {
                    navController.navigate("details")
                }
            )
        }

        composable("details") {
            DetailScreen(navController)
        }

    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Nav3_PracticeTheme {
        Greeting("Android")
    }
}