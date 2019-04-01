package com.example.brewie.network


import com.example.brewie.model.Beer
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BrewApi {
    @GET("beers")
    fun getBeers(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int): Call<List<Beer>>
}