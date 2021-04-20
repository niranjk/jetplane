package com.niranjan.jetplane.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import com.niranjan.jetplane.ui.viewmodel.ArticleViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: ArticleViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Text(text = "hello")
            }
        }
        viewModel.getArticles()
        setResultObserving()
    }

    private fun setResultObserving() {
        viewModel.articleLiveData.observe(
            this,
            {
                setContent {
                    MaterialTheme {
                        Text(text = "hello")
                    }
                }
            }
        )
    }
}