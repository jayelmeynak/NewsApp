package com.example.samplenewsapp.data.network.models
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("PLUGIN_IS_NOT_ENABLED")
@Serializable
data class SourceDTO(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String
)