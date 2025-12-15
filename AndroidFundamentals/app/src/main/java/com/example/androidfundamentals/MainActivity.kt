package com.example.androidfundamentals

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var imageView: ImageView
    private lateinit var btnNext: Button
    private lateinit var btnPrev: Button

    // List of images
    private val images = arrayOf(
        R.drawable.pic1,
        R.drawable.pic2,
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        btnNext = findViewById(R.id.btnNext)
        btnPrev = findViewById(R.id.btnPrev)

        // Show first image
        imageView.setImageResource(images[currentIndex])

        btnNext.setOnClickListener {
            currentIndex = (currentIndex + 1) % images.size
            imageView.setImageResource(images[currentIndex])
        }

        btnPrev.setOnClickListener {
            currentIndex = (currentIndex - 1 + images.size) % images.size
            imageView.setImageResource(images[currentIndex])
        }
    }
}
