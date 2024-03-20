package com.example.androidmaster.examplemvvm.domain

import com.example.androidmaster.examplemvvm.data.model.QuoteModel
import com.example.androidmaster.examplemvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {


    operator fun invoke():QuoteModel? {
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (0..quotes.size-1).random()
            return quotes[randomNumber]
        }
        return null
    }

}