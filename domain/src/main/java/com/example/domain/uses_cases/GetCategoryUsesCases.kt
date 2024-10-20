package com.example.domain.uses_cases

import com.example.domain.model.categories.CategoryResponseModel
import com.example.domain.repository.CategoryRepository
import com.example.domain.utlis.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCategoryUsesCases @Inject constructor(
    val repository: CategoryRepository,

    ) {
    operator fun invoke(language: String): Flow<Resource<CategoryResponseModel>> = flow {

        try {
            emit(Resource.Loading(message = "the data Loading"))
            val category = repository.getCategory(lang = language)
            emit(Resource.Success<CategoryResponseModel>(data = category))

        } catch (e: Exception) {
            emit(Resource.Error<CategoryResponseModel>(message = "${e.localizedMessage}: An Expectation error happened"))
        }


    }
}