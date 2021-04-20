package com.niranjan.jetplane.data.article

sealed class ArticleUiModel

data class AroundMeImageUiMOdel (
    val type: String,
    val url: String): ArticleUiModel()

data class AroundMeHeaderUiModel (
    val type: String,
    val category: String,
    val name: String,
    val isFavoriteIcon: String,
    val distanceIcon: String,
    val distanceText: String,
    val status: String,
    val workingHoursDetails: String,
    val addresss: String,
    val tags: List<String>): ArticleUiModel()

data class AroundMeActionsUiModel (
    val type: String,
    val actions: List<String>): ArticleUiModel()

data class AroundMeDiscountUiModel (
    val type: String,
    val title: String,
    val promotionList: List<PromotionsUiModel>): ArticleUiModel()

data class PromotionsUiModel(
    val type: String,
    val icon: String,
    val text: String
)

data class AroundMeSellerUiMOdel (
    val type: String,
    val title: String,
    val description: String,
    val mail: String,
    val website: String): ArticleUiModel()

data class AroundMeButtonUiMOdel (
    val type: String,
    val text: String,
    val action : ActionsUiModel): ArticleUiModel()

data class ActionsUiModel(
    val actionType: String,
    val url: String
)