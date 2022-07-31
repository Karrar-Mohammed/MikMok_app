package com.example.mikmok_app.util

import com.example.mikmok_app.data.domain.Feed
import com.example.mikmok_app.data.domain.Item

fun setVideoList(feed: Feed): MutableList<Item> {
    val videosList = mutableListOf<Item>()
    feed.items.forEach {
        val item = Item(
            id = it.id,
            year = it.year,
            title = it.title,
            description = it.description,
            duration = it.duration,
            director = it.director,
            url = it.url,
            art = it.director
        )
        videosList.add(item)
    }
    return videosList
}