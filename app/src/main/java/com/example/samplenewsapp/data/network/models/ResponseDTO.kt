package com.example.samplenewsapp.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Suppress("PLUGIN_IS_NOT_ENABLED")
@Serializable
data class ResponseDTO<E>(
    @SerialName("status") val status: String,
    @SerialName("totalResults") val totalResults: Int,
    @SerialName("articles") val articles: List<E>
)
