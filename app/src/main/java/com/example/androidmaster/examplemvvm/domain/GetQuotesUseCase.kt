package com.example.androidmaster.examplemvvm.domain

import com.example.androidmaster.examplemvvm.data.QuoteRepository
import com.example.androidmaster.examplemvvm.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke() = repository.getAllQuotes()

}