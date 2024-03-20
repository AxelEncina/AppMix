package com.example.androidmaster.examplemvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidmaster.examplemvvm.data.model.QuoteModel
import com.example.androidmaster.examplemvvm.data.model.QuoteProvider
import com.example.androidmaster.examplemvvm.domain.GetQuotesUseCase
import com.example.androidmaster.examplemvvm.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel: ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>() //el valor de adentro va a ir cambiando
    val isLoading = MutableLiveData<Boolean>()

    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()
            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result.random())
                isLoading.postValue(false)
            }
        }
    }
    fun randomQuote() {
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if (quote != null) {
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }


}