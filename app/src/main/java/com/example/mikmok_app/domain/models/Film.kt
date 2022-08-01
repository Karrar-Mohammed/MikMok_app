package com.example.mikmok_app.domain.models

data class Film(
    val id: String,
    val year: Int,
    val duration: Int,
    val title: String,
    val director: String,
    val description: String,
    val url: String,
    val art: String,
    val feedImageUrl: String,
    val feedTitle: String
) {
}