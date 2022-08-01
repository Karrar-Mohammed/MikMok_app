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
import com.google.android.exoplayer2.ui.StyledPlayerView


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
        val currentItem = list[position]
        holder.binding.apply {
            textTitle.text = currentItem.videoTitle
            textDescription.text = currentItem.videoDescription

            setExoPlayer(videoPlayers,root.context,currentItem.video)
        }
    }


    private fun setExoPlayer(
        videoPlayers: StyledPlayerView,
        context: Context,
        videoUrl: String
    ) {
        exoPlayer = ExoPlayer.Builder(context).build()
        videoPlayers.player = exoPlayer
        videoPlayers.useController = false
        val mediaItem = MediaItem.fromUri(videoUrl)
        exoPlayer.addMediaItem(mediaItem)
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
    }

    override fun getItemCount(): Int = list.size

    class VideoPlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemVideoPlayerBinding.bind(itemView)
    }
}