package com.dee.home.popularmovies.data

import com.dee.home.common.MovieListRequest
import com.dee.home.common.MovieListResponse
import com.dee.network.NetworkResult

/**
 * Created by Hein Htet
 */
class PopularMoviesDataSource(private val apiService: PopularMoviesApiService){
   suspend fun getPopularMovies(request: MovieListRequest?): NetworkResult<MovieListResponse> {
       return apiService.fetchPopularMovies(request)
   }
}