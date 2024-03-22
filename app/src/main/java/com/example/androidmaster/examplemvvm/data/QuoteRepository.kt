package com.example.androidmaster.examplemvvm.data

import com.example.androidmaster.examplemvvm.data.database.dao.QuoteDao
import com.example.androidmaster.examplemvvm.data.database.entities.QuoteEntity
import com.example.androidmaster.examplemvvm.data.network.QuoteService
import com.example.androidmaster.examplemvvm.domain.model.Quote
import com.example.androidmaster.examplemvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api:QuoteService,
    private val quoteDao:QuoteDao) {


    suspend fun getAllQuotesFromApi():List<Quote>{
        val response = api.getQuotes() //llamamos al backend y recuperamos las citas
        return response.map {it.toDomain() } //mapeamos la respuesta a un modelo de dominio
    }

    suspend fun getAllQuotesFromDatabase():List<Quote>{
        val response = quoteDao.getAllQuotes() //recuperamos las citas de la base de datos
        return response.map {it.toDomain() } //mapeamos la respuesta a un modelo de dominio
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes) //insertamos las citas en la base de datos
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes() //borramos todas las citas de la base de datos
    }
}