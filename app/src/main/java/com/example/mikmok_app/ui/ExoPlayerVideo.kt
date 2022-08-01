package com.example.mikmok_app.ui

import android.content.Context
import android.net.Uri
import com.example.mikmok_app.R
import com.example.mikmok_app.ui.util.istVisible
import com.example.mikmok_app.ui.util.showMessage
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSource

class ExoPlayerVideo(
    private val holder: VideoPlayerAdapter.VideoPlayerViewHolder,
) {
    private lateinit var exoPlayer: ExoPlayer

    fun initialization(): ExoPlayer {
        exoPlayer = ExoPlayer.Builder(holder.binding.root.context).build()
        addListener()
        return exoPlayer
    }

    private fun addListener() {
        exoPlayer.addListener(object : Player.Listener {

            override fun onPlaybackStateChanged(playbackState: Int) {
                holder.binding.apply {
                    when (playbackState) {
                        Player.STATE_BUFFERING -> loadingVideo.visibility = istVisible(true)
                        Player.STATE_READY -> loadingVideo.visibility = istVisible(false)
                        Player.STATE_ENDED -> {
                            exoPlayer.seekTo(0)
                            exoPlayer.play()
                        }
                        else -> loadingVideo.visibility = istVisible(true)
                    }
                }
            }

            override fun onPlayerError(error: PlaybackException) {
                showMessage(holder.binding.root.context, R.string.error_show_video)
            }
        })
    }

    companion object {
        fun mediaSource(context: Context,videoUrl: String): MediaSource {
            val dataSourceFactory =  DefaultDataSource.Factory(context)
            return ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(MediaItem.fromUri(Uri.parse(videoUrl)))
        }
    }

}