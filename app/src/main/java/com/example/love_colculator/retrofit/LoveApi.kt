package com.example.love_colculator.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface LoveApi {
//    .url("https://love-calculator.p.rapidapi.com/getPercentage?sname=Alice&fname=John")
//    .get()
//    .addHeader("X-RapidAPI-Key", "c925af2796mshb82fc88b2420a27p17a961jsncc2cc23edde1")
//    .addHeader("X-RapidAPI-Host", "love-calculator.p.rapidapi.com")
    @GET("getPercentage")
    fun getPercentage(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "c925af2796mshb82fc88b2420a27p17a961jsncc2cc23edde1",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com",
    ): Call<LoveModel>
}