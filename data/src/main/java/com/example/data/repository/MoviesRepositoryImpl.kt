package com.example.data.repository

import com.example.data.mapper.MoviesMapper
import com.example.data.remote.MovieApi
import com.example.domain.model.movies.MoviesResponseModel
import com.example.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesMapper: MoviesMapper,
    private val movieApi: MovieApi

) : MoviesRepository {
    override suspend fun getMovies(lang: String, page: Int, generalID: Int): MoviesResponseModel {
      return  moviesMapper.fromRemoteMoviesToModel(
            movieApi.getMoviesApi(language = lang, page = page, generalId = generalID)
        )
    }

}