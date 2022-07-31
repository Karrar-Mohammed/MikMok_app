package com.example.mikmok_app.data

import com.example.mikmok_app.data.domain.VideoPlayer

object DataManager {
    fun getVideoPlayer(): List<VideoPlayer> = listOf(
        VideoPlayer("Life is hard but beautiful","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less"),
        VideoPlayer("nature is beautiful","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"),
    )
}