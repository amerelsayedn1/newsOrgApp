package com.alpha.neworg.data.model


data class ItemModel(
    val sourceModel: SourceModel = SourceModel(),
    val author: String = "",
    val title: String = "",
    val description: String = "",
    val url: String = "",
    val urlToImage: String = "",
    val publishedAt: String = "",
    val content: String = ""
)