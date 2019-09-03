package com.example.recreatemost.views.activities

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.recreatemost.R
import com.example.recreatemost.models.Article
import kotlinx.android.synthetic.main.activity_description.*

class DescriptionActivity : AppCompatActivity() {

    private var currentArticle: Article? = null

    companion object {
        const val EXTRA_ARTICLE = "SELECTED_ARTICLE"
    }

    // TODO: Add back arrow

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_description)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        // Set WebView with the intent send
        val serializableFromExtra = intent.getStringExtra(EXTRA_ARTICLE)
        if (serializableFromExtra != null) {
            descriptionActivityWebViewMain.webViewClient = WebViewClient()
            descriptionActivityWebViewMain.loadUrl(serializableFromExtra)
        }
    }
}