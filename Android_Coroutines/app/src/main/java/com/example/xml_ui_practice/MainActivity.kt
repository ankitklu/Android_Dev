package com.example.xml_ui_practice

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
import com.example.xml_ui_practice.ui.theme.XML_UI_PracticeTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.withContext
import android.widget.TextView


class MainActivity : ComponentActivity() {

    val TAG = "MainActivity"
    val TAG2 = "AnkitActivity"
    private lateinit var tvDummy: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // launch coroutine
//        GlobalScope.launch {
//            println("Hello From Main Threadn from println")
//            delay(2000)
//            Log.d(TAG, "Hello from Coroutine ${Thread.currentThread().name}")
//        }
//        Log.d(TAG, "Hello from Coroutine ${Thread.currentThread().name}")

        // suspend coroutine
//        GlobalScope.launch {
//            val net = delayNetworkCall()
//            val net2 = delayNetworkCall2()
//
//            Log.d(TAG2 , "The log for delayNetworkCall which is delayed by 3seconds")
//            Log.d(TAG2, "The log for delayNetworkCall2 which is delayed by 3 seconds")
//
//
//        }

        // Context coroutine
        /*
        -> We can also pass parameters in the launch() function with Dispatchers.<somehthing>
        -> Dispatchers.Main that  will start the launch in the main thread which involves changes in the UI and all.
        -> Dispatchers.IO will help us in all the IO i.e. input output operations involving the network calls and all the writing operations in Db and files
        -> Dispatcher.Default is used when we do some complex or heavy operations or calculations that blocks the main thread
         */
        tvDummy = findViewById(R.id.tvDummy)

        GlobalScope.launch(Dispatchers.IO){
            val answer = delayNetworkCall()
            Log.d(TAG2, "Staritng coroutine in thread ${Thread.currentThread().name}")
            withContext(Dispatchers.Main){  // we can change the dispatcher from IO to Main
                Log.d(TAG2, "Setting text in thread")
                tvDummy.text = answer
            }
        }

    }
}
suspend fun delayNetworkCall(): String{
    delay(3000)
    return "Network Call 1 delayed by 3 sec";
}

suspend fun delayNetworkCall2(): String{
    delay(3000)
    return "Network Call 1 delayed by 3 sec";
}
