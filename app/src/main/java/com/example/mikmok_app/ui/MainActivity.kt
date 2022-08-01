package com.example.mikmok_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.mikmok_app.data.network.Client
import com.example.mikmok_app.databinding.ActivityMainBinding
import com.example.mikmok_app.domain.models.Film

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {
        PagerSnapHelper().attachToRecyclerView(binding.recyclerview)

        val okHTTP = Client()
        okHTTP.getFilmsList(callback = object : Client.ApiCallback{
            override fun onFilmsReady(list: List<Film>) {
                // implement your recyclerView
                val adapter = VideoPlayerAdapter(list)
                binding.recyclerview.adapter = adapter
            }

        })
    }
}