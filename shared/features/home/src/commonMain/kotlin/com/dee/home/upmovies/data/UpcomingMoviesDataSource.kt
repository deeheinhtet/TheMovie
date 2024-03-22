package com.dee.home.upmovies.data

import com.dee.network.NetworkResult
import com.dee.home.common.MovieListRequest
import com.dee.home.common.MovieListResponse
import com.dee.home.upmovies.data.UpcomingMoviesApiService

/**
 * Created by Hein Htet
 */
class UpcomingMoviesDataSource(private val apiService: UpcomingMoviesApiService){
   suspend fun getTradingMovies(request: MovieListRequest?): NetworkResult<MovieListResponse> {
       return apiService.fetchUpcomingMovies(request)
   }
}