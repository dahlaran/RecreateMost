package com.example.recreatemost.views.activities

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.recreatemost.R
import com.example.recreatemost.models.Article
import kotlinx.android.synthetic.main.activity_description.*

class DescriptionActivity: AppCompatActivity(){

    private var currentArticle: Article? = null

    companion object{
        const val EXTRA_ARTICLE = "SELECTED_ARTICLE"
    }

    // TODO: Add back arrow

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val serializableFromExtra =  intent.getStringExtra(EXTRA_ARTICLE)

        setContentView(R.layout.activity_description)
        if (serializableFromExtra != null){
            descriptionActivityWebViewMain.webViewClient = WebViewClient()
            descriptionActivityWebViewMain.loadUrl(serializableFromExtra)
        }
    }
}