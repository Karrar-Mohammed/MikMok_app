package com.example.mikmok_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mikmok_app.data.domain.Item
import com.example.mikmok_app.data.network.RequestUsingOkHTTP
import com.example.mikmok_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var videosList = listOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()
    }

    private fun setup() {
//        val adapter = VideoPlayerAdapter(DataManager.getVideoPlayer())
//        binding.recyclerview.adapter = adapter

        RequestUsingOkHTTP().makeRequestUsingOkHTTP()
        videosList = RequestUsingOkHTTP().items
        Log.d("MainActivity", "onCreate: $videosList")
    }
}