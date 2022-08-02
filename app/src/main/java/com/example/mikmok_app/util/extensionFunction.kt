package com.example.mikmok_app.util

import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

fun StyledPlayerView.playVideoFromUrl(videoUrl: String) {
    val exoPlayer = ExoPlayer.Builder(this.context).build()
    this.player = exoPlayer
    this.useController = false
    val mediaItem = MediaItem.fromUri(videoUrl)
    exoPlayer.setMediaItem(mediaItem)
    exoPlayer.prepare()
    exoPlayer.playWhenReady = true
}