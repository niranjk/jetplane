package com.niranjan.jetplane.data.article

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class ArticleRepository(): ArticleService{
    override fun getArticles(): List<ArticleUiModel> =
        listOf(
            AroundMeImageUiMOdel(
                "Image",
                "https://placeholder.url"
            ),
            AroundMeHeaderUiModel(
                "HeaderInfo",
                "Enoteca",
                "Baffo di Vino",
                "https://icon",
                "https://icon",
                "100 m da te",
                "Aperto",
                "chiude alle 19:05",
                "Viale Europa 170",
                listOf("A domicilio","Ritiro in negozio", "Codice QR"),
            ),
            AroundMeActionsUiModel(
                "Actions",
                listOf("Chat", "Call", "Share")
            ),
            AroundMeDiscountUiModel(
                "Promo",
                "Sconti attivi",
                listOf(
                    PromotionsUiModel(
                        "Promo",
                        "https://icon.img",
                        "10% cashback con ScontiPoste"
                    ),
                    PromotionsUiModel(
                        "PromoQR",
                        "https://icon.img",
                        "10% cashback se paghi con Codice QR"
                    )
                )
            ),
            AroundMeSellerUiMOdel(
                "Info",
                "Info su Venditore",
                "Lorum ipsum dolor sit amet, consectectru asdfk, sdlfk , jsdfksdf , jskdf ",
                "venditore@gmail.com",
                "www.venditore.com"
            ),
            AroundMeButtonUiMOdel(
                "Button",
                "Paga ora in negozio",
                ActionsUiModel(
                    "website",
                    "https://dalsdkfj.com"
                )
            )
        )

}