package com.example.recreatemost.data

import com.example.recreatemost.models.FranceFootballCategory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface FranceFootballApiServices {
    companion object {
        private const val API_URL = "http://app.francefootball.fr/"
        fun create(): FranceFootballApiServices {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API_URL)
                .build()

            return retrofit.create(FranceFootballApiServices::class.java)
        }
    }

    @GET("json/les_plus/plus.json")
    fun getAll(): Call<List<FranceFootballCategory>>
}