package com.niranjan.jetplane.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.niranjan.jetplane.data.article.ArticleRepository
import com.niranjan.jetplane.data.article.ArticleUiModel
import kotlinx.coroutines.launch

class ArticleViewModel(
    private val articleRepository: ArticleRepository
) : ViewModel(){

    val articleLiveData = MutableLiveData<List<ArticleUiModel>>()
    fun getArticles() {
        articleLiveData.value = articleRepository.getArticles()
    }
}