package com.example.domain.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.model.movies.MoviesItemModel
import com.example.domain.repository.MoviesRepository

class MoviePagingSource(
    private val repository: MoviesRepository,
    private val language: String,
    private val catId: Int

) : PagingSource<Int, MoviesItemModel>() {
    override fun getRefreshKey(state: PagingState<Int, MoviesItemModel>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MoviesItemModel> {
    return    try {
            val page = params.key ?: 1
            val response = repository.getMovies(lang = language, page = page, generalID = catId)
            LoadResult.Page(
                data = response.moveList,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.moveList.isEmpty()) null else page.plus(1)
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}