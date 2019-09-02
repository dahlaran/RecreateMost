package com.example.recreatemost.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recreatemost.models.Category
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryRepository {
    private var apiServices: FranceFootballApiServices = FranceFootballApiServices.create()
    private var allCategories: MutableLiveData<List<Category>> = MutableLiveData()

    // TODO: If enough time create a room database

    init {
        updateCategories()
    }

    /**
     * Get Categories from URL
     */
    private fun updateCategories(){
        apiServices.getAll().enqueue(object : Callback<List<Category>>{
            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                Log.e(CategoryRepository::class.java.name, t.message?: "error when getAll")
            }

            override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                if (response.isSuccessful){
                    Log.i(CategoryRepository::class.java.name, response.message())
                    allCategories.postValue(response.body())
                }
                else {
                    // Error has occurred
                    Log.e(CategoryRepository::class.java.name, response.message())
                }
            }

        })
    }

    /**
     * Get list of categories
     */
    fun getAll(): LiveData<List<Category>> {
        return allCategories
    }
}