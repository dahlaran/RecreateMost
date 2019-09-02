package com.example.recreatemost.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recreatemost.R
import com.example.recreatemost.models.Category
import com.example.recreatemost.viewmodels.HomeActivityViewModel
import com.example.recreatemost.views.adapters.CategoryAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeActivityViewModel

    // TODO: Add swipeLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        homeActivityRecyclerView.layoutManager = LinearLayoutManager(this)
        homeActivityRecyclerView.itemAnimator = DefaultItemAnimator()

        val adapter = CategoryAdapter()
        homeActivityRecyclerView.adapter = adapter


        // Set ViewModel
        viewModel = ViewModelProviders.of(this).get(HomeActivityViewModel::class.java)
        viewModel.getAll().observe(this, Observer<List<Category>> {
            adapter.submitList(it)
        })
    }
}
