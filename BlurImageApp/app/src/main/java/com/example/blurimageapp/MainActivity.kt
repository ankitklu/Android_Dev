package com.example.blurimageapp

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
import com.example.blurimageapp.ui.theme.BlurImageAppTheme
import android.graphics.RenderEffect
import android.graphics.Shader

import android.widget.ImageView



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Get reference of ImageView
        val imageView = findViewById<ImageView>(R.id.logoImage)

        // 2. Create blur effect
        val blurEffect = RenderEffect.createBlurEffect(
            40f, // blur radius X
            40f, // blur radius Y
            Shader.TileMode.CLAMP
        )

        // 3. Apply blur to ImageView
        imageView.setRenderEffect(blurEffect)
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
    BlurImageAppTheme {
        Greeting("Android")
    }
}