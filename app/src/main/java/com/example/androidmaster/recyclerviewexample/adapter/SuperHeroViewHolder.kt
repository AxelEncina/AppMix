package com.example.androidmaster.recyclerviewexample.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidmaster.R
import com.example.androidmaster.databinding.ItemSuperhero2Binding
import com.example.androidmaster.recyclerviewexample.SuperHero

class SuperHeroViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val binding = ItemSuperhero2Binding.bind(view)

    /* el binding me permite eliminar all esto
    private val superHero = view.findViewById<TextView>(R.id.tvSuperheroName)
    private val publisher = view.findViewById<TextView>(R.id.tvSuperheroPublisher)
    private val realName = view.findViewById<TextView>(R.id.tvSuperheroRealName)
    private val photo = view.findViewById<ImageView>(R.id.ivSuperhero)
    */
    fun bind(superHeroModel: SuperHero, onClickListener:(SuperHero) -> Unit) {
        binding.tvSuperheroName.text = superHeroModel.superHero
        binding.tvSuperheroPublisher.text = superHeroModel.publisher
        binding.tvSuperheroRealName.text = superHeroModel.realName
        Glide.with(binding.ivSuperhero.context).load(superHeroModel.photo).into(binding.ivSuperhero)
        //itemView es toda la celda
        itemView.setOnClickListener { onClickListener(superHeroModel)}

    }
}