package com.example.mikmok_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.mikmok_app.data.DataManager
import com.example.mikmok_app.data.network.Client
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.mikmok_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dataManager = DataManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {
        val okHTTP = Client(dataManager)
        okHTTP.getFilmsList{
            runOnUiThread {
                val adapter = VideoPlayerAdapter(dataManager.filmsList)
                binding.recyclerview.adapter = adapter
                PagerSnapHelper().attachToRecyclerView(binding.recyclerview)

            }
        }

    }
}