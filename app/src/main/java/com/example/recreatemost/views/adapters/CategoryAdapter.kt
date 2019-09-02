package com.example.recreatemost.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recreatemost.R
import com.example.recreatemost.models.Category
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter : ListAdapter<Category, CategoryAdapter.HomeViewHolder>(Category.DIFF_CALLBACK){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return HomeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val currentCategory: Category = getItem(position)

        holder.textTitle.text = currentCategory.titre

        holder.recycler.layoutManager = LinearLayoutManager(holder.recycler.context)
        holder.recycler.itemAnimator = DefaultItemAnimator()

        val adapter = ArticleAdapter(currentCategory.items)
        holder.recycler.adapter = adapter
    }

    // Inner ViewHolder
    inner class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textTitle: TextView = view.itemCategoryTextTitle
        val recycler: RecyclerView = view.itemCategoryRecyclerArticle
    }

}