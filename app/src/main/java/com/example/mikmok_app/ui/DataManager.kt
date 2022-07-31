package com.example.mikmok_app.ui

import com.example.mikmok_app.ui.domain.VideoPlayer

object DataManager {
    fun getVideoPlayer(): List<VideoPlayer> = listOf(
        VideoPlayer("Life is hard but beautiful","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less","https://android-tv-classics.firebaseapp.com/content/patchwork_girl_oz/media_patchwork_girl_oz.mp4"),
        VideoPlayer("nature is beautiful","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,","https://android-tv-classics.firebaseapp.com/content/tarzan_1918/media_tarzan_1918.mp4"),
    )
}