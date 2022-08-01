package com.example.mikmok_app.domain

import com.example.mikmok_app.data.apiModels.FilmDto

data class Feed(
    val id: String,
    val title: String,
    val description: String,
    val image: String,
    val items: List<FilmDto>
)