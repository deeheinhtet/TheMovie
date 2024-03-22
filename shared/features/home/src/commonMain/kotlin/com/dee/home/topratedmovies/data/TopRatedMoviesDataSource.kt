package com.dee.home.topratedmovies.data

import com.dee.network.NetworkResult
import com.dee.home.common.MovieListRequest
import com.dee.home.common.MovieListResponse
import com.dee.home.topratedmovies.data.TopRatedMoviesApiService

/**
 * Created by Hein Htet
 */
class TopRatedMoviesDataSource(private val apiService: TopRatedMoviesApiService){
   suspend fun getTopRatedMovies(request: MovieListRequest?): NetworkResult<MovieListResponse> {
       return apiService.fetchTopRatedMovies(request)
   }
}