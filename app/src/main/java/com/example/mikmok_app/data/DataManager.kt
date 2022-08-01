package com.example.mikmok_app.data

import com.example.mikmok_app.data.domain.Film

class DataManager {

    private val _filmsList = mutableListOf<Film>()
    val filmsList : List<Film>
        get() = _filmsList

    fun addFilm(film: Film) {
        _filmsList.add(film)
    }

}