package com.example.androidmaster.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import com.example.androidmaster.R
import com.example.androidmaster.databinding.ActivitySuperHeroListBinding

class SuperHeroListActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySuperHeroListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }
    //el viewbinding es la nueva forma de enganchar las vistas

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean { return false } //aunque no se use no se puede eliminar
        })
    }
    private fun searchByName(query: String) { //para consumir una api rest
https://superheroapi.com/api/2815997405207328/search/name
    }
}