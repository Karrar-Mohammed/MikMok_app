package com.example.mikmok_app.data.domain

data class Feed(
    val id: String,
    val title: String,
    val description: String,
    val image: String,
    val items: List<Film>
)