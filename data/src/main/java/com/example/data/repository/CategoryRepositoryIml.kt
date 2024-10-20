package com.example.data.repository

import com.example.data.mapper.CategoriesMapper
import com.example.data.remote.MovieApi
import com.example.domain.model.categories.CategoryResponseModel
import com.example.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryIml@Inject constructor(
    private val movieApi: MovieApi,
    private val categoriesMapper: CategoriesMapper
):CategoryRepository {
    override suspend fun getCategory(lang: String): CategoryResponseModel {
        return categoriesMapper.fromRemoteToModel(movieApi.getCategoryApi(lang))
    }
}