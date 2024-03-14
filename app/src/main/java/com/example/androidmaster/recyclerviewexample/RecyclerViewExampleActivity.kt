package com.example.androidmaster.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmaster.R
import com.example.androidmaster.databinding.ActivityRecyclerViewExampleBinding
import com.example.androidmaster.recyclerviewexample.adapter.SuperHeroAdapter

class RecyclerViewExampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewExampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this) //con GridLayoutManager(this, 2) se muestra en 2 columnas
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.recyclerSuperHero.layoutManager = manager
        binding.recyclerSuperHero.adapter =
            SuperHeroAdapter(SuperHeroProvider.superHeroList) { superHero ->
            onItemSelected(
                superHero
            )
        }
        binding.recyclerSuperHero.addItemDecoration(decoration)
    }

    fun onItemSelected(superHero: SuperHero) {
        Toast.makeText(this, "You selected ${superHero.superHero}", Toast.LENGTH_SHORT).show()
    }
}