package com.example.recreatemost.models

import androidx.recyclerview.widget.DiffUtil

data class Category(
    val items: List<Article>,
    val suffixe: String,
    val titre: String
) {
    /**
     * Compare used for listData in CategoryAdapter
     */
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Category>() {
            override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
                return oldItem.suffixe == newItem.suffixe && oldItem.titre == newItem.titre
            }

            override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
                return oldItem.items.count() == newItem.items.count() && oldItem.items == newItem.items
            }
        }
    }
}