package com.example.domain.model.movies

data class MoviesResponseModel(
    val moveList:List<MoviesItemModel> ,
    val page: Int,
    val totalPages:Long,
    val totalResult: Long
)
data class MoviesItemModel(
    val id:Int,
    val imageUrl:String?="",
    val name: String

)