package com.example.recreatemost.utilis

import com.example.recreatemost.models.Article
import com.example.recreatemost.models.Category
import com.example.recreatemost.models.FranceFootballCategory

class ConverterFranceFootToLequipe {
    companion object {
        fun convert(category: FranceFootballCategory): Category {
            val listOfArticle = ArrayList<Article>()

            category.items.forEach {
                listOfArticle.add(
                    Article(
                        it.id,
                        it.lien,
                        it.titre,
                        it.type,
                        it.fullUrl,
                        it.images.mobile,
                        it.nb.toString() + " " + category.suffixe,
                        it.isFF
                    )
                )
            }
            return Category(listOfArticle, category.titre)
        }
    }
}