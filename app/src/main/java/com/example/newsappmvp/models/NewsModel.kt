package com.example.newsappmvp.models
import kotlinx.serialization.Serializable

@Serializable
data class NewsModel(
    val articles:List< Article> ,
    val status: String,
    val totalResults: Int
)