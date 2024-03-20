package com.example.androidmaster.examplemvvm.data.model

import com.google.gson.annotations.SerializedName

//recuperamos la info de nuestra base de datos online y lo guardamos localmente en room o shared preferences
data class QuoteModel(@SerializedName("quote") val quote: String, @SerializedName("author") val author: String)
