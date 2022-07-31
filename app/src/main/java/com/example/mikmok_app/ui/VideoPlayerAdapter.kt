package com.example.mikmok_app.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mikmok_app.databinding.ItemVideoPlayerBinding
import com.example.mikmok_app.ui.domain.VideoPlayer
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.ui.PlayerView

class VideoPlayerAdapter(
    private val list: List<VideoPlayer>
    ): RecyclerView.Adapter<VideoPlayerAdapter.VideoPlayerViewHolder>() {


    private lateinit var simpleExoPlayer:ExoPlayer
    private lateinit var playerView: PlayerView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoPlayerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(com.example.mikmok_app.R.layout.item_video_player, parent, false)
        return VideoPlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoPlayerViewHolder, position: Int) {
        holder.binding.apply {
            textTitle.text = list[position].videoTitle
            textDescription.text = list[position].videoDescription
                    simpleExoPlayer = ExoPlayer.Builder(holder.binding.root.context).build()
        playerView = videoPlayerss
        playerView.player = simpleExoPlayer
        val mediaItem: MediaItem = MediaItem.fromUri(list[position].video)
        simpleExoPlayer.addMediaItem(mediaItem)
        simpleExoPlayer.prepare()

        simpleExoPlayer.playWhenReady = true

        }
    }

    override fun getItemCount(): Int = list.size

    class VideoPlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemVideoPlayerBinding.bind(itemView)
    }
}