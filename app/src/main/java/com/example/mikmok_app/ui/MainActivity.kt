package com.example.mikmok_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mikmok_app.data.DataManager
import com.example.mikmok_app.data.network.Client
import com.example.mikmok_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dataManager = DataManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {
        val adapter = VideoPlayerAdapter(dataManager.getVideoPlayer())
        binding.recyclerview.adapter = adapter

        val okHTTP = Client(dataManager)
        okHTTP.getFilmsList()
    }
}