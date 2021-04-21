package com.niranjan.jetplane.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.niranjan.jetplane.R
import com.niranjan.jetplane.data.article.*

@Composable
fun ArticleScreenCompose(articleList: List<ArticleUiModel>){
    MaterialTheme {
        ArticleComponents(articleList = articleList)
    }
}

val padding = 20.dp

@Composable
fun ArticleComponents(articleList: List<ArticleUiModel>) {

    /*
    Surface(
        Modifier.fillMaxSize()
            .padding(padding)
    ) {
        LazyColumn(content = { /*TODO*/ })
    }
     */

    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(4.dp),
        elevation = 4.dp
    ){
        Column(
            Modifier.padding(padding)
        ){
            for (component in articleList) {
                when (component) {
                    is AroundMeImageUiMOdel -> {
                        ImageViewComponent()
                    }
                    is AroundMeButtonUiMOdel -> {
                        ButtonViewComponent(component)
                    }
                    is AroundMeDiscountUiModel -> {
                        DiscountViewComponet(component)
                    }
                    is AroundMeHeaderUiModel -> {
                        HeaderViewComponent(component)
                    }
                    is AroundMeActionsUiModel -> {
                        ActionViewComponent(component)
                    }
                    is AroundMeSellerUiMOdel -> {
                        SellerViewComponent(component)
                    }
                }
            }
        }
    }
}

@Composable
fun SellerViewComponent(component: AroundMeSellerUiMOdel) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(4.dp),
        elevation = 4.dp
    ) {
        Column(
            Modifier.padding(padding)
        ) {
            Text(
                component.title
            )
            Text(
                component.description
            )
            Text(
                component.mail
            )
            Text(
                component.website
            )
        }
    }
}

@Composable
fun ActionViewComponent(component: AroundMeActionsUiModel) {

}

@Composable
fun HeaderViewComponent(component: AroundMeHeaderUiModel) {

}

@Composable
fun DiscountViewComponet(component: AroundMeDiscountUiModel) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(4.dp),
        elevation = 4.dp
    ) {
        Column(
            Modifier.padding(padding)
        ) {
           Text(
               component.title
           )
            Text(
                component.promotionList.get(0).text
            )
            Text(
                component.promotionList.get(1).text
            )
        }
    }
}

@Composable
fun ButtonViewComponent(component: AroundMeButtonUiMOdel) {
    Button(onClick = {
        // do this action
        component.action
    })
    {
        Text(text = "${component.text}")
    }
}

@Preview
@Composable
fun ImageViewComponent() {
    Box( Modifier.fillMaxWidth().height(200.dp)) {
        Image(
            painter = painterResource(R.drawable.test_img),
            contentDescription = "asldkfj",
            modifier = Modifier
                .fillMaxSize()
                .clip(MaterialTheme.shapes.medium)

        )
    }
}

