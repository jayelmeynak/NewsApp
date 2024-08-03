package com.example.samplenewsapp.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("PLUGIN_IS_NOT_ENABLED")
@Serializable
data class ArticleDTO(
    @SerialName("source") val source: SourceDTO,
    @SerialName("author") val author: String,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
    @SerialName("url") val url: String,
    @SerialName("urlToImage") val urlToImage: String,
    @SerialName("content") val content: String,
)