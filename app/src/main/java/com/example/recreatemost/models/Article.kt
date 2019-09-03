package com.example.recreatemost.models

import com.google.gson.annotations.SerializedName


data class Article(
    val id: String,
    val link: String,
    val title: String,
    val type: String,
    @SerializedName("web_url") val webUrl: String,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("count_description") val countDescription: String,
    @SerializedName("is_france_foot") val isFranceFoot: Boolean
)