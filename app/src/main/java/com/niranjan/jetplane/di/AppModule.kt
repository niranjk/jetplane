package com.niranjan.jetplane.di

import com.niranjan.jetplane.data.article.ArticleRepository
import com.niranjan.jetplane.ui.viewmodel.ArticleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appmodule = module {

    viewModel { ArticleViewModel(get()) }

    single { ArticleRepository() }
}