package com.example.androidmaster.examplemvvm.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.androidmaster.examplemvvm.domain.model.Quote

@Entity(tableName = "quote_table")
data class QuoteEntity(
    @PrimaryKey(autoGenerate = true) //con esto le decimos a room que genere un id automaticamente
    @ColumnInfo(name="id") val id:Int = 0,
    @ColumnInfo(name="quote") val quote:String,
    @ColumnInfo(name="author") val author:String
)

fun Quote.toDatabase() = QuoteEntity(quote = quote, author = author) //funcion de extension para convertir un Quote a un QuoteEntity
