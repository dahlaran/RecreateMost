package com.example.recreatemost.models

import androidx.recyclerview.widget.DiffUtil

data class Category(
    var items: List<Article>,
    val title: String
) {
    /**
     * Compare used for listData in CategoryAdapter
     */
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Category>() {
            override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
                return oldItem.items.count() == newItem.items.count() && oldItem.items == newItem.items
            }
        }
    }
}