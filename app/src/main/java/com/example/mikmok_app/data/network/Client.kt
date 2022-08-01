package com.example.mikmok_app.data.network

import android.os.Handler
import android.os.Looper
import com.example.mikmok_app.domain.ClassicItem
import com.example.mikmok_app.domain.models.Film
import com.example.mikmok_app.util.Constants
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class Client {
    private val client = OkHttpClient()

    interface ApiCallback {
        fun onFilmsReady(list: List<Film>)
    }

    fun getFilmsList(callback: ApiCallback?) {

        val request = Request.Builder().url(Constants.URL).build()
        client
            .newCall(request)
            .enqueue(
                object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        Handler(Looper.getMainLooper()).post {
                            callback?.onFilmsReady(emptyList())
                        }
                    }

                    override fun onResponse(call: Call, response: Response) {
                        response.body?.string().let { jsonString ->
                            val result = Gson().fromJson(jsonString, ClassicItem::class.java)
                            val list = mutableListOf<Film>()
                            result.feed.forEach { item ->
                                item.items.forEach {
                                    val film = Film(
                                        id = it.id,
                                        year = it.year,
                                        duration = it.duration,
                                        title = it.title,
                                        director = it.director,
                                        description = it.description,
                                        art = it.art,
                                        url = it.url,
                                        feedImageUrl = item.image,
                                        feedTitle = item.title
                                    )
                                    list.add(film)
                                }
                            }
                            Handler(Looper.getMainLooper()).post {
                                callback?.onFilmsReady(list)
                            }

                        }
                    }
                }
            )
    }
}