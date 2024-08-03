package com.example.samplenewsapp.data.network

import androidx.annotation.IntRange
import com.example.samplenewsapp.data.network.models.ArticleDTO
import com.example.samplenewsapp.data.network.models.Language
import com.example.samplenewsapp.data.network.models.ResponseDTO
import com.example.samplenewsapp.data.network.models.SortBy
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.Date

interface ApiService {

    @GET("/everything")
    suspend fun everything(
        @Query("q") q: String? = null,
        @Query("from") from: Date? = null,
        @Query("to") to: Date? = null,
        @Query("languages") language: List<Language>? = null,
        @Query("sortBy") sortBy: SortBy? = null,
        @Query("pageSize") @IntRange(from = 0, to = 100) pageSize: Int = 100,
        @Query("page") @IntRange(from = 1) page: Int = 1,
    ):Result<ResponseDTO<ArticleDTO>>
}

fun NewsApi(
    baseUrl: String,
    apiKey: String,
    okHttpClient: OkHttpClient? = null,
    json: Json = Json,
): ApiService {
    return retrofit(baseUrl, apiKey, okHttpClient, json).create()
}

private fun retrofit(
    baseUrl: String,
    apiKey: String,
    okHttpClient: OkHttpClient?,
    json: Json,
): Retrofit {

    val jsonConverterFactory = json.asConverterFactory("application/json".toMediaType())

    val modifiedOkHttpClient = (okHttpClient?.newBuilder() ?: OkHttpClient.Builder())
        .addInterceptor(NewsApiKeyInterceptor(apiKey))
        .build()

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(jsonConverterFactory)
        .addCallAdapterFactory(ResultCallAdapterFactory.create())
        .client(modifiedOkHttpClient)
        .build()
}