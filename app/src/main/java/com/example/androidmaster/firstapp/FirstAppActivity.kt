package com.example.androidmaster.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import com.example.androidmaster.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)

        val btnClickeame = findViewById<AppCompatButton>(R.id.btnClickMe)

        btnClickeame.setOnClickListener {
            Log.i("FirstAppActivity", "Click me button clicked")

        }
    }
}