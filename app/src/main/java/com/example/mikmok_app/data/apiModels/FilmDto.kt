package com.example.mikmok_app.data.apiModels

data class FilmDto(
    val id: String,
    val year: Int,
    val duration: Int,
    val title: String,
    val director: String,
    val description: String,
    val url: String,
    val art: String
)