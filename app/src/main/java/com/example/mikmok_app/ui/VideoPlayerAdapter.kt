package com.example.mikmok_app.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mikmok_app.R
import com.example.mikmok_app.data.domain.Film
import com.example.mikmok_app.databinding.ItemVideoPlayerBinding
import com.example.mikmok_app.util.playVideoFromUrl



class VideoPlayerAdapter(private val list: List<Film>) : RecyclerView.Adapter<VideoPlayerAdapter.VideoPlayerViewHolder>() {


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
            videoPlayer.playVideoFromUrl(currentItem.url, root.context)

        }
    }

    override fun getItemCount(): Int = list.size

    class VideoPlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemVideoPlayerBinding.bind(itemView)
    }
}