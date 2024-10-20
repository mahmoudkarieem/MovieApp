package com.example.movieapp.di

import com.example.data.mapper.CategoriesMapper
import com.example.data.mapper.MoviesMapper
import com.example.data.remote.MovieApi
import com.example.data.repository.CategoryRepositoryIml
import com.example.data.repository.MoviesRepositoryImpl
import com.example.domain.repository.CategoryRepository
import com.example.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApiCategoryMovies(retrofit: Retrofit): MovieApi =
        retrofit.create(MovieApi::class.java)


    @Provides
    @Singleton
    fun provideMoviesRepository(
        moviesMapper: MoviesMapper, movieApi: MovieApi
    ): MoviesRepository = MoviesRepositoryImpl(
        moviesMapper = moviesMapper,
        movieApi = movieApi
    )

    @Provides
    @Singleton
    fun provideCategoryRepository(
        movieApi: MovieApi, categoriesMapper: CategoriesMapper
    ): CategoryRepository = CategoryRepositoryIml(
        movieApi = movieApi,
        categoriesMapper = categoriesMapper
    )
}