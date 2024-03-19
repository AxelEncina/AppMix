package com.example.androidmaster.examplemvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.androidmaster.databinding.ActivityExampleMvvmactivityBinding
import com.example.androidmaster.examplemvvm.viewmodel.QuoteViewModel

class ExampleMVVMActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExampleMvvmactivityBinding

    private val quoteViewModel : QuoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExampleMvvmactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.quoteModel.observe(this, Observer {
            binding.tvQuote.text = it.quote
            binding.tvAuthor.text = it.author
        })

        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }
}