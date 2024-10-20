package com.example.domain.uses_cases

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.domain.model.movies.MoviesItemModel
import com.example.domain.paging_source.MoviePagingSource
import com.example.domain.repository.MoviesRepository
import com.example.domain.utlis.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMoviesUsesCases @Inject constructor(
    private val repository: MoviesRepository

) {
    operator fun invoke(language: String, catId: Int): Flow<Resource<Pager<Int, MoviesItemModel>>> =
        flow {
            try {
                emit(Resource.Loading(message = "the data movies loading"))
                val getMovies = Pager(
                    config = PagingConfig(pageSize = 10),
                    pagingSourceFactory = {
                        MoviePagingSource(
                            language = language,
                            repository = repository,
                            catId = catId
                        )
                    }
                )


            } catch (e: Exception) {
                emit(Resource.Error<Pager<Int, MoviesItemModel>>(message = "${e.localizedMessage}: An Expectation error happened"))
            }

        }
}