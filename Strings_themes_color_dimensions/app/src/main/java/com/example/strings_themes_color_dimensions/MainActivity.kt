package com.example.strings_themes_color_dimensions

import android.os.Bundle
import android.util.Log
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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.strings_themes_color_dimensions.databinding.ActivityMainBinding
import com.example.strings_themes_color_dimensions.ui.theme.Strings_themes_color_dimensionsTheme

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    var TAG = "ankit"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todoList = mutableListOf(
            Todo("Android Devs", false),
            Todo("Badminton", true),
            Todo("Leetcode", true),
            Todo("Gym", true),
            Todo("Chai", false),
            Todo("Dinner", false),
        )

        val adapter = TodoAdapter(todoList)

        binding.rvTodo.layoutManager = LinearLayoutManager(this)
        binding.rvTodo.adapter = adapter

        binding.btnAddTodo.setOnClickListener {
            Log.d(TAG,"Add button clicked")
            val title = binding.editText.text.toString()
            if (title.isNotBlank()) {
                todoList.add(Todo(title, false))
                adapter.notifyItemInserted(todoList.size - 1)
                binding.editText.text.clear()
            }
        }
    }
}
