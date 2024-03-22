package com.dee.home.nowplayingmovies.data

import com.dee.network.NetworkResult
import com.dee.home.common.MovieListRequest
import com.dee.home.common.MovieListResponse

/**
 * Created by Hein Htet
 */
class NowPlayingMoviesDataSource(private val apiService: NowMoviesApiService){
   suspend fun getNowPlayingMovies(request: MovieListRequest?): NetworkResult<MovieListResponse> {
       return apiService.fetchNowPlayingMovies(request)
   }
}