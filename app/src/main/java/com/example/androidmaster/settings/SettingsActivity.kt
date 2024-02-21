package com.example.androidmaster.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidmaster.R
import com.example.androidmaster.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}