package com.dee.home.upmovies.data

import com.dee.network.BaseRemoteRepository
import com.dee.network.NetworkResult
import com.dee.home.common.MovieListRequest
import com.dee.home.common.MovieListResponse
import com.dee.home.upmovies.data.UpcomingMoviesDataSource

/**
 * Created by Hein Htet
 */
class UpcomingMoviesRepository(private val dataSource: UpcomingMoviesDataSource) :
    BaseRemoteRepository<MovieListRequest, MovieListResponse>() {

    override suspend fun process(params: MovieListRequest?): NetworkResult<MovieListResponse> {
        return dataSource.getTradingMovies(params)
    }
}