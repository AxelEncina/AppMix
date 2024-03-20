package com.example.androidmaster.examplemvvm.data

import com.example.androidmaster.examplemvvm.data.model.QuoteModel
import com.example.androidmaster.examplemvvm.data.model.QuoteProvider
import com.example.androidmaster.examplemvvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes() //llamamos al backend y recuperamos las citas
        QuoteProvider.quotes = response //guardamos las citas en nuestra base de datos local
        return response
    }
}