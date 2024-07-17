package com.example.androidmaster.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.androidmaster.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Obtén la referencia del TextView
        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Obtén el nombre del Intent
        val name = intent.getStringExtra("EXTRA_NAME").orEmpty()

        // Configura el texto del TextView
        tvResult.text = "Hola $name"
    }
}