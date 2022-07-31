package com.example.mikmok_app.data.network

import android.util.Log
import com.example.mikmok_app.data.domain.ClassicItem
import com.example.mikmok_app.data.domain.Item
import com.example.mikmok_app.util.Constants
import com.example.mikmok_app.util.setVideoList
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class RequestUsingOkHTTP {
    private var _responseItemList = mutableListOf<Item>()
    val items: List<Item> get() = _responseItemList

    fun makeRequestUsingOkHTTP() {
        val client = OkHttpClient()
        val request = Request.Builder().url(Constants.URL).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("TAG", "onFailure: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string().let { jsonString ->
                    val result = Gson().fromJson(jsonString, ClassicItem::class.java)
                    result.feed.forEach { item ->
                        _responseItemList = setVideoList(item)
                        Log.d("TAG", "onResponse: $items")
                    }
                }
            }
        }
        )
    }
}