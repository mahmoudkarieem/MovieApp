package com.example.data.remote

import MovieResponse
import com.example.data.constants.Constants
import com.example.data.dto.categories.CategoryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("genre/movie/list")
    suspend fun getCategoryApi(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("language") language: String = "en"
    ): CategoryResponse

    @GET("discover/movie")
    suspend fun getMoviesApi(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("page") page: Int,
        @Query("language") language: String = "en",
        @Query("with_genres") generalId: Int

    ):MovieResponse

}