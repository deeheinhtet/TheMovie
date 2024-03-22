package com.dee.home.tradingmovies.data

import com.dee.network.BaseRemoteRepository
import com.dee.network.NetworkResult
import com.dee.home.common.MovieListRequest
import com.dee.home.common.MovieListResponse
import com.dee.home.tradingmovies.data.TrendingMoviesDataSource

/**
 * Created by Hein Htet
 */
class TrendingMoviesRepository(private val dataSource: TrendingMoviesDataSource) :
    BaseRemoteRepository<MovieListRequest, MovieListResponse>() {

    override suspend fun process(params: MovieListRequest?): NetworkResult<MovieListResponse> {
        return dataSource.getTradingMovies(params)
    }
}