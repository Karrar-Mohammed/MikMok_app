package com.example.mikmok_app.util

import android.content.Context
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

fun StyledPlayerView.playVideoFromUrl(videoUrl: String, context: Context) {
    val exoPlayer = ExoPlayer.Builder(context).build()
    this.player = exoPlayer
    this.useController = false
    val mediaItem = MediaItem.fromUri(videoUrl)
    exoPlayer.addMediaItem(mediaItem)
    exoPlayer.prepare()
    exoPlayer.playWhenReady = true
}