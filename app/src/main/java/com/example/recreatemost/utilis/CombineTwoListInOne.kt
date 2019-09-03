package com.example.recreatemost.utilis

import com.example.recreatemost.models.Article
import com.example.recreatemost.models.Category

class CombineTwoListInOne {
    companion object {

        // TODO: Sort by numbers (Share/reads/...)
        /**
         * Combine FranceFootball list with L'equipe list
         * Possible Improvement: select tmpList as the list with the bigger number of items
         */
        fun conbine(arrayOne: List<Category>, arrayTwo: List<Category>): List<Category> {
            val tmpList = ArrayList<Category>()
            val tmpListArticle = ArrayList<Article>()
            var findInList = false
            tmpList.addAll(arrayOne)

            // Search category with the same name
            arrayTwo.forEach { twoCategory ->
                tmpList.forEach { tmpCategory ->
                    if (tmpCategory.title == twoCategory.title) {
                        tmpListArticle.clear()
                        tmpListArticle.addAll(tmpCategory.items)
                        // Fill category with new items
                        twoCategory.items.forEach {
                            findInList = false
                            for (nb: Int in tmpCategory.items.indices) {
                                if (it.id == tmpListArticle[nb].id)
                                    findInList = true
                            }
                            // If it was not in the list, add it
                            if (!findInList)
                                tmpListArticle.add(it)
                        }
                        // Set item list with a new list of combined items
                        tmpCategory.items = tmpListArticle.clone() as List<Article>
                    }
                }
            }
            return tmpList
        }
    }
}