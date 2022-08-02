package com.example.mikmok_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.mikmok_app.data.DataManager
import com.example.mikmok_app.data.network.Client
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
                val mAdapter = VideoPlayerAdapter(dataManager.filmsList)
                binding.recyclerview.adapter = mAdapter
                PagerSnapHelper().attachToRecyclerView(binding.recyclerview)

            }
        }

    }
}