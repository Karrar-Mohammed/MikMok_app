package com.example.mikmok_app.data.network

import android.util.Log
import com.example.mikmok_app.data.DataManager
import com.example.mikmok_app.data.domain.ClassicItem
import com.example.mikmok_app.util.Constants
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class Client(val dataManager: DataManager) {
    private val client = OkHttpClient()

    fun getFilmsList(setupRecycler: () -> Unit) {
        val request = Request.Builder().url(Constants.URL).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("TAG", "onFailure: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string().let { jsonString ->
                    val result = Gson().fromJson(jsonString, ClassicItem::class.java)
                    result.feed.forEach { item ->
                        item.items.forEach {
                            dataManager.addFilm(it)
                        }
                    }
                }
                setupRecycler()
            }
        }
        )
    }
}