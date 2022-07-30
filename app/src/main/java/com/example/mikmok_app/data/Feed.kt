package com.example.mikmok_app.data

data class Feed(
    val id: String,
    val title: String,
    val description: String,
    val image: String,
    val items: List<Item>
)