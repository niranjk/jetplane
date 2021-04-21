package com.niranjan.jetplane.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.niranjan.jetplane.ui.components.ArticleScreenCompose
import com.niranjan.jetplane.ui.viewmodel.ArticleViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: ArticleViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getArticles()
        setResultObserving()
    }

    private fun setResultObserving() {
        viewModel.articleLiveData.observe(
            this,
            {   data ->
                setContent {
                    ArticleScreenCompose(articleList = data)
                }
            }
        )
    }
}