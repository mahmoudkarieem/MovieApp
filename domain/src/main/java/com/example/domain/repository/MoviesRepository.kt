package com.example.domain.repository

import com.example.domain.model.movies.MoviesResponseModel

interface MoviesRepository {
    suspend fun getMovies(
        lang: String,
        page: Int,
        generalID:Int

    ): MoviesResponseModel
}