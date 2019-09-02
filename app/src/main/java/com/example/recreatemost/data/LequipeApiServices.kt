package com.example.recreatemost.data

import com.example.recreatemost.models.Category
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface LequipeApiServices {

    companion object {
        private const val API_URL2 = "http://client.cocoapps.fr/"
        fun create(): FranceFootballApiServices {

            val retrofit = Retrofit.Builder()
                .baseUrl(API_URL2)
                .build()

            return retrofit.create(FranceFootballApiServices::class.java)
        }
    }

    @GET("lequipe/test_ios.json")
    fun getAll(): Call<Category>
}