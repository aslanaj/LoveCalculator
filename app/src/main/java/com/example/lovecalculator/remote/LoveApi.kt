package com.example.lovecalculator.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun percentageNames(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "6029b7f3afmshd0f832968f3935ep1e5d18jsnafd6dda11d27",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ): Call<LoveModel>

}