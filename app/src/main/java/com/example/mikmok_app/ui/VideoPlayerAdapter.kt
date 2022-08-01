package com.example.mikmok_app.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mikmok_app.databinding.ItemVideoPlayerBinding
import com.example.mikmok_app.domain.models.Film

class VideoPlayerAdapter(private val films: List<Film>) :
    RecyclerView.Adapter<VideoPlayerAdapter.VideoPlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoPlayerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(com.example.mikmok_app.R.layout.item_video_player, parent, false)
        return VideoPlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoPlayerViewHolder, position: Int) {
        holder.binding.apply {
            textTitle.text = films[position].title
            textDescription.text = films[position].description
            textNamePerson.text = films[position].feedTitle
            Glide.with(holder.itemView).load(films[position].feedImageUrl).into(imagePerson)
        }
    }

    override fun getItemCount(): Int = films.size

    class VideoPlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemVideoPlayerBinding.bind(itemView)
    }
}