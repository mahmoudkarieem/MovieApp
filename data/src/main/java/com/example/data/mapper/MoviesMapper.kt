package com.example.data.mapper

import Movie
import MovieResponse
import com.example.domain.model.movies.MoviesItemModel
import com.example.domain.model.movies.MoviesResponseModel

class MoviesMapper {

    fun fromRemoteMoviesToModel(Obj: MovieResponse): MoviesResponseModel {
        return MoviesResponseModel(
            moveList = fromRemoteItemToModel(Obj.results),

            totalPages = Obj.totalPages,
            totalResult = Obj.totalResults,
            page = Obj.page,

            )
    }

    fun fromRemoteItemToModel(Obj: List<Movie>): List<MoviesItemModel> {
        return Obj.map {
            MoviesItemModel(
                id = it.id,
                imageUrl = it.posterPath,
                name = it.title

            )
        }
    }
}