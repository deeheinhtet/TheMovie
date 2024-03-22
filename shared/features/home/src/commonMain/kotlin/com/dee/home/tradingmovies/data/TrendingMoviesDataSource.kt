package com.dee.home.tradingmovies.data

import com.dee.network.NetworkResult
import com.dee.home.common.MovieListRequest
import com.dee.home.common.MovieListResponse
import com.dee.home.tradingmovies.data.TrendingMoviesApiService

/**
 * Created by Hein Htet
 */
class TrendingMoviesDataSource(private val apiService: TrendingMoviesApiService){
   suspend fun getTradingMovies(request: MovieListRequest?): NetworkResult<MovieListResponse> {
       return apiService.fetchTradingMovies(request)
   }
}