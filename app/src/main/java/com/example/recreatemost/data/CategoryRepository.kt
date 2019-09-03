package com.example.recreatemost.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recreatemost.models.Category
import com.example.recreatemost.models.FranceFootballCategory
import com.example.recreatemost.models.Section
import com.example.recreatemost.utilis.CombineTwoListInOne
import com.example.recreatemost.utilis.ConverterFranceFootToLequipe
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryRepository {
    private var apiServicesFranceFoot: FranceFootballApiServices =
        FranceFootballApiServices.create()
    private var apiServicesLequipe: LequipeApiServices = LequipeApiServices.create()
    private var allCategories: MutableLiveData<List<Category>> = MutableLiveData()

    private var franceFootList: List<Category> = ArrayList()
    private var lequipeList: List<Category> = ArrayList()

    init {
        updateCategories()
    }

    /**
     * Get Categories from URL
     */
    private fun updateCategories() {
        getCategoriesFromFranceFoot()
        getCategoriesFromLequipe()
    }

    private fun getCategoriesFromFranceFoot() {
        apiServicesFranceFoot.getAll().enqueue(object : Callback<List<FranceFootballCategory>> {
            override fun onFailure(call: Call<List<FranceFootballCategory>>, t: Throwable) {
                Log.e(
                    CategoryRepository::class.java.name,
                    t.message ?: "error when getAll FranceFootball"
                )
            }

            override fun onResponse(
                call: Call<List<FranceFootballCategory>>,
                response: Response<List<FranceFootballCategory>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    Log.i(CategoryRepository::class.java.name, response.message())
                    //allCategories.postValue(response.body())
                    val newCategoryList: ArrayList<Category> = ArrayList()

                    response.body()?.forEach {
                        newCategoryList.add(ConverterFranceFootToLequipe.convert(it))
                    }
                    franceFootList = newCategoryList

                    val assambledList = CombineTwoListInOne.conbine(franceFootList, lequipeList)

                    allCategories.postValue(assambledList)
                    Log.e(CategoryRepository::class.java.name, allCategories.toString())
                } else {
                    // Error has occurred
                    Log.e(CategoryRepository::class.java.name, response.message())
                }
            }

        })
    }

    private fun getCategoriesFromLequipe() {
        apiServicesLequipe.getAll().enqueue(object : Callback<Section> {
            override fun onFailure(call: Call<Section>, t: Throwable) {
                Log.e(CategoryRepository::class.java.name, t.message ?: "error when getAll Lequipe")
            }

            override fun onResponse(call: Call<Section>, response: Response<Section>) {
                if (response.isSuccessful && response.body() != null) {
                    Log.i(CategoryRepository::class.java.name, response.message())

                    lequipeList = response.body()?.sections ?: ArrayList()

                    val assambledList = CombineTwoListInOne.conbine(lequipeList, franceFootList)

                    allCategories.postValue(assambledList)
                    Log.e(CategoryRepository::class.java.name, allCategories.toString())
                } else {
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