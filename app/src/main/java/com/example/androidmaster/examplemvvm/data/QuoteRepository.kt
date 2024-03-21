package com.example.androidmaster.examplemvvm.data

import com.example.androidmaster.examplemvvm.data.model.QuoteModel
import com.example.androidmaster.examplemvvm.data.model.QuoteProvider
import com.example.androidmaster.examplemvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api:QuoteService, private val quoteProvider: QuoteProvider) {


    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes() //llamamos al backend y recuperamos las citas
        quoteProvider.quotes = response //guardamos las citas en nuestra base de datos local
        return response
    }
}