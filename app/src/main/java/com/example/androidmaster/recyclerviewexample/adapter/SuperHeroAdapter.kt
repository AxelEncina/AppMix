package com.example.androidmaster.recyclerviewexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmaster.R
import com.example.androidmaster.recyclerviewexample.SuperHero
import com.example.androidmaster.recyclerviewexample.SuperHeroProvider.Companion.superHeroList

class SuperHeroAdapter(private val superheroList: List<SuperHero>, private val onClickListener:(SuperHero) -> Unit): RecyclerView.Adapter<SuperHeroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_superhero2, parent, false)
        return SuperHeroViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return superheroList.size
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val item = superHeroList[position]
        holder.bind(item, onClickListener)
    }
}