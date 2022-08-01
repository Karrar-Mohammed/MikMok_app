package com.example.mikmok_app.ui

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.mikmok_app.R
import com.example.mikmok_app.databinding.ItemVideoPlayerBinding
import com.example.mikmok_app.ui.domain.VideoPlayer
import com.example.mikmok_app.ui.util.istVisible
import com.example.mikmok_app.ui.util.showMessage
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player


class VideoPlayerAdapter(
    private val list: List<VideoPlayer>,
) : RecyclerView.Adapter<VideoPlayerAdapter.VideoPlayerViewHolder>() {

    public lateinit var exoPlayer: ExoPlayer

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoPlayerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_video_player, parent, false)
        return VideoPlayerViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: VideoPlayerViewHolder,
        position: Int,
    ) {
        holder.binding.apply {
            textTitle.text = list[position].videoTitle
            textDescription.text = list[position].videoDescription

            exoPlayer = ExoPlayer.Builder(holder.binding.root.context).build()
            exoPlayer.addListener(object : Player.Listener {

                override fun onPlaybackStateChanged(playbackState: Int) {
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

                override fun onPlayerError(error: PlaybackException) {
                    showMessage(holder.binding.root.context, R.string.error_show_video)
                }
            })
            videoPlayerss.player = exoPlayer
            videoPlayerss.useController = false
            exoPlayer.seekTo(0)

            val mediaItem: MediaItem = MediaItem.fromUri(list[position].video)

            exoPlayer.addMediaItem(mediaItem)
            exoPlayer.prepare()
            exoPlayer.playWhenReady = true
            exoPlayer.play()
        }

    }

    override fun getItemCount(): Int = list.size

    class VideoPlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemVideoPlayerBinding.bind(itemView)
    }
}