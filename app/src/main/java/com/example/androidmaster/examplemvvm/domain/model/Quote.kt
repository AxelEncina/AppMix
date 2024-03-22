package com.example.androidmaster.examplemvvm.domain.model

import com.example.androidmaster.examplemvvm.data.database.entities.QuoteEntity
import com.example.androidmaster.examplemvvm.data.model.QuoteModel

data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain()= Quote(quote, author) //funcion de extension para convertir un QuoteModel a un Quote
fun QuoteEntity.toDomain()= Quote(quote, author) //funcion de extension para convertir un QuoteEntity a un Quote