package com.example.mikmok_app.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mikmok_app.R
import com.example.mikmok_app.databinding.ItemVideoPlayerBinding
import com.example.mikmok_app.ui.domain.VideoPlayer
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.ui.PlayerView


class VideoPlayerAdapter(private val list: List<VideoPlayer>) : RecyclerView.Adapter<VideoPlayerAdapter.VideoPlayerViewHolder>() {

    private lateinit var exoPlayer: ExoPlayer

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
            setExoPlayer(holder,videoPlayerss,root.context,position)
        }

    }

    private fun setExoPlayer(
        holder: VideoPlayerViewHolder,
        videoPlayers: PlayerView,
        context: Context,
        position: Int
    ) {
        exoPlayer = ExoPlayerVideo(holder).initialization()
        videoPlayers.player = exoPlayer
        videoPlayers.useController = false
        exoPlayer.seekTo(0)
        val mediaSource = ExoPlayerVideo.mediaSource(context, list[position].video)
        exoPlayer.setMediaSource(mediaSource)
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
        exoPlayer.play()
    }

    override fun getItemCount(): Int = list.size

    class VideoPlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemVideoPlayerBinding.bind(itemView)
    }
}