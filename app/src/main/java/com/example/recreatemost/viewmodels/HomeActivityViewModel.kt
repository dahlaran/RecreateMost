package com.example.recreatemost.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.recreatemost.data.CategoryRepository
import com.example.recreatemost.models.Category

class HomeActivityViewModel(application: Application) : AndroidViewModel(application) {
    private var categoryRepository: CategoryRepository = CategoryRepository()
    private var allCategories: LiveData<List<Category>> = categoryRepository.getAll()


    fun getAll(): LiveData<List<Category>> {
        return allCategories
    }
}