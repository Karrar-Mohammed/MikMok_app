package com.example.mikmok_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mikmok_app.data.ClassicItem
import com.example.mikmok_app.data.Feed
import com.example.mikmok_app.data.Item
import com.example.mikmok_app.databinding.ActivityMainBinding
import com.example.mikmok_app.util.Constants
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val client = OkHttpClient()
    private val videosList = mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        makeRequestUsingOkHTTP()
    }

    private fun makeRequestUsingOkHTTP() {
        val request = Request.Builder().url(Constants.URL).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("TAG", "onFailure: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string().let { jsonString ->
                    val result = Gson().fromJson(jsonString, ClassicItem::class.java)
                    result.feed.forEach { item ->
                        setVideoList(item)
                        Log.d("videosList", videosList.first().toString())
                    }
                }
            }
        })
    }

    private fun setVideoList(item: Feed): List<Item> {
        item.items.forEach {
            val item = Item(
                id = it.id,
                year = it.year,
                title = it.title,
                description = it.description,
                duration = it.duration,
                director = it.director,
                url = it.url,
                art = it.director
            )
            videosList.add(item)
        }
        return videosList
    }
}