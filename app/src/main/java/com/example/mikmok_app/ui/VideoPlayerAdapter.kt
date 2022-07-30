package com.example.mikmok_app.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mikmok_app.databinding.ItemVideoPlayerBinding
import com.example.mikmok_app.data.domain.VideoPlayer

class VideoPlayerAdapter(private val list: List<VideoPlayer>): RecyclerView.Adapter<VideoPlayerAdapter.VideoPlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoPlayerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(com.example.mikmok_app.R.layout.item_video_player, parent, false)
        return VideoPlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoPlayerViewHolder, position: Int) {
        holder.binding.apply {
            textTitle.text = list[position].videoTitle
            textDescription.text = list[position].videoDescription
//            Glide.with(holder.itemView).load(list[position].image).into(myVideoPlayer)
        }
    }

    override fun getItemCount(): Int = list.size

    class VideoPlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemVideoPlayerBinding.bind(itemView)
    }
}