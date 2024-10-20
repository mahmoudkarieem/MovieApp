package com.example.domain.repository

import com.example.domain.model.categories.CategoryResponseModel

interface CategoryRepository {
    suspend fun getCategory(
        lang: String,

        ): CategoryResponseModel
}