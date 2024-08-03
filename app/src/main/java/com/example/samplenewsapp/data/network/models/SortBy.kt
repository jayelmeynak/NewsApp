package com.example.samplenewsapp.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("PLUGIN_IS_NOT_ENABLED")
@Serializable
enum class SortBy {

    @SerialName("relevancy")
    RELEVANCY,

    @SerialName("popularity")
    POPULARITY,

    @SerialName("publishedAt")
    PUBLISHED_AT,
}