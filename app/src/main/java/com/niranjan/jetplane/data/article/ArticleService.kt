package com.niranjan.jetplane.data.article



interface ArticleService {
    fun getArticles(): List<ArticleUiModel>
}