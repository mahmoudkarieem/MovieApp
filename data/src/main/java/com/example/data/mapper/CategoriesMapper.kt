package com.example.data.mapper

import com.example.data.dto.categories.CategoryResponse
import com.example.data.dto.categories.Genre
import com.example.domain.model.categories.CategoryResponseModel
import com.example.domain.model.categories.GenreModel

class CategoriesMapper {


    fun fromRemoteToModel(Obj: CategoryResponse): CategoryResponseModel {
        return CategoryResponseModel(

            genres = Obj.genres.map {
                fromRemoteGeneToModel(it)

            }
        )


    }

    fun fromRemoteGeneToModel(Obj: Genre): GenreModel {
        return GenreModel(
            id = Obj.id,
            name = Obj.name
        )
    }
}