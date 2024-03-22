package com.example.androidmaster.examplemvvm.domain

import com.example.androidmaster.examplemvvm.data.QuoteRepository
import com.example.androidmaster.examplemvvm.data.model.QuoteModel
import com.example.androidmaster.examplemvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (0..quotes.size-1).random()
            return quotes[randomNumber]
        }
        return null
    }

}