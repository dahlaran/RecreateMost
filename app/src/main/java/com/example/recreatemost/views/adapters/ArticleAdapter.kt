package com.example.recreatemost.views.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recreatemost.R
import com.example.recreatemost.models.Article
import com.example.recreatemost.views.activities.DescriptionActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_article.view.*

class ArticleAdapter(private val articleList: List<Article>) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentArticle: Article = articleList[position]

        holder.article = currentArticle
        holder.titleText.text = currentArticle.titre
        holder.topNumberText.text = (position + 1).toString() + "."

        // TODO: load image for different screen size
        Picasso.get().load(currentArticle.images.mobile).into(holder.imageBackground)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    /**
     * Inner ViewHolder
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
                val currentArticle = article
                if (currentArticle != null) {
                    val intent = Intent(view.context, DescriptionActivity::class.java)
                    intent.putExtra(DescriptionActivity.EXTRA_ARTICLE, currentArticle.fullUrl)
                    view.context.startActivity(intent)
                }
            }
        }

        var article: Article? = null
        val titleText: TextView = view.itemArticleTextTitle
        val topNumberText: TextView = view.itemArticleTextTopNumber
        val shareArticleText: TextView = view.itemArticleTextShareArticle
        val imageBackground: ImageView = view.itemArticleImageBackground
    }

}