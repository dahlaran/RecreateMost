package com.example.recreatemost.data

import com.example.recreatemost.models.Section
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface LequipeApiServices {

    companion object {
        private const val API_URL2 = "http://client.cocoapps.fr/"
        fun create(): LequipeApiServices {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API_URL2)
                .build()

            return retrofit.create(LequipeApiServices::class.java)
        }
    }

    @GET("lequipe/test_ios.json")
    fun getAll(): Call<Section>
}