package com.example.mikmok_app.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mikmok_app.R
import com.example.mikmok_app.data.domain.Film
import com.example.mikmok_app.databinding.ItemVideoPlayerBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem


class VideoPlayerAdapter(private val list: List<Film>) :
    RecyclerView.Adapter<VideoPlayerAdapter.VideoPlayerViewHolder>() {


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
            textTitle.text = currentItem.title
            textDescription.text = currentItem.description
            textDate.text = currentItem.year.toString()
            Glide.with(root.context).load(currentItem.art).into(imageFilm)
            val exoPlayer = ExoPlayer.Builder(root.context).build()
            videoPlayer.player = exoPlayer
            videoPlayer.useController = false
            exoPlayer.addMediaItem(MediaItem.fromUri(currentItem.url))
            exoPlayer.prepare()

        }
    }

    override fun onViewAttachedToWindow(holder: VideoPlayerViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.binding.videoPlayer.player?.apply {
            if (this.currentPosition != 0L) {
                this.seekTo(0)
            }
        }
        holder.binding.videoPlayer.player?.playWhenReady = true
        Log.v("adapter", "attached: w")
    }

    override fun onViewDetachedFromWindow(holder: VideoPlayerViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.binding.videoPlayer.player?.playWhenReady = false
        Log.v("adapter", "unattached: x")
    }

    override fun getItemCount(): Int = list.size

    class VideoPlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemVideoPlayerBinding.bind(itemView)
    }
}