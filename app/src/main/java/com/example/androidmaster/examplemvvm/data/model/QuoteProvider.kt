package com.example.androidmaster.examplemvvm.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton //tiene que llevar esto porque sino me toma una instancia con lista vacia y otra con la lista de quotes, entonces al hacer click en la app no me cambia la cita
class QuoteProvider @Inject constructor(){
        var quotes: List<QuoteModel> = emptyList() //lista de quotes
}
