package com.example.recreatemost.models


data class Article(
    val actif: Boolean,
    val fullUrl: String,
    val id: String,
    val images: Images,
    val isFF: Boolean,
    val lien: String,
    val nb: Int,
    val titre: String,
    val type: String,
    val type_contenu: String
)