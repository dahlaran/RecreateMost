package com.example.recreatemost.models

data class FranceFootballArticle(
    val actif: Boolean,
    val fullUrl: String,
    val id: String,
    val images: FranceFootballImages,
    val isFF: Boolean,
    val lien: String,
    val nb: Int,
    val titre: String,
    val type: String,
    val type_contenu: String
)