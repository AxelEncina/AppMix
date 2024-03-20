package com.example.androidmaster.examplemvvm.domain

import com.example.androidmaster.examplemvvm.data.QuoteRepository
import com.example.androidmaster.examplemvvm.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel>? {
        return repository.getAllQuotes()
    }
}