package com.niranjan.jetplane.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.niranjan.jetplane.R
import com.niranjan.jetplane.data.article.*

@Composable
fun ArticleScreenCompose(articleList: List<ArticleUiModel>){
    MaterialTheme {
    }
}

val padding = 20.dp

@Composable
fun ArticleComponents(articleList: List<ArticleUiModel>) {

    /*
    for (component in articleList) {
        when (component) {
            is AroundMeImageUiMOdel -> {
                ImageViewComponent()
            }
            /*
            is AroundMeHeaderUiModel -> {
                HeaderViewComponent(component)
            }
            is AroundMeActionsUiModel -> {
                ActionViewComponent(component)
            }
            is AroundMeDiscountUiModel -> {
                DiscountViewComponet(component)
            }
            is AroundMeSellerUiMOdel -> {
                SellerViewComponent(component)
            }
            is AroundMeButtonUiMOdel -> {
                ButtonViewComponent(component)
            }

             */
        }
    }

     */
}

@Composable
fun ImageViewComponent() {
    Image(
        painter = painterResource(R.drawable.ic_launcher_background),
        contentDescription = "asldkfj",
        modifier = Modifier
            .fillMaxSize()
            .clip(MaterialTheme.shapes.medium)

    )
}

