package com.example.androidmaster.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService { //en la interfaz no se mete codigo como tal

    @GET("/api/2815997405207328/search/{name}") //se pone el endpoint
    suspend fun getSuperheroes(@Path("name") superheroName: String): Response<SuperHeroDataResponse> //se pone el metodo que se va a usar (get, post, put, delete, etc.

    @GET("/api/2815997405207328/{id}")
    suspend fun getSuperheroDetail(@Path("id") superheroId: String): Response<SuperHeroDetailResponse>

}