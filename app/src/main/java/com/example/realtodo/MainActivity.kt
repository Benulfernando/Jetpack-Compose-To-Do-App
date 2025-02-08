package com.example.realtodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val todoviewModel = ViewModelProvider(this)[TodoviewModel::class.java]
        enableEdgeToEdge()
        setContent {
            TodoList(todoviewModel)
        }
    }
}



