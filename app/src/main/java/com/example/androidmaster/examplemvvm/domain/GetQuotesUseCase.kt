package com.example.androidmaster.examplemvvm.domain

import com.example.androidmaster.examplemvvm.data.QuoteRepository
import com.example.androidmaster.examplemvvm.data.database.entities.toDatabase
import com.example.androidmaster.examplemvvm.data.model.QuoteModel
import com.example.androidmaster.examplemvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke() :List<Quote> {
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()){
            repository.clearQuotes()//borramos las citas antiguas, porque sino voy a estar insertando listas repetidas todas las veces
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        }else{
            repository.getAllQuotesFromDatabase()
        }
    }

}