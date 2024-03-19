package com.example.androidmaster.examplemvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidmaster.examplemvvm.model.QuoteModel
import com.example.androidmaster.examplemvvm.model.QuoteProvider

class QuoteViewModel: ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>() //el valor de adentro va a ir cambiando

    fun randomQuote() {
        val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }
}