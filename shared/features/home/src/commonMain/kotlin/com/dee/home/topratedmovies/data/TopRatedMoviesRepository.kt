package com.dee.home.topratedmovies.data

import com.dee.network.BaseRemoteRepository
import com.dee.network.NetworkResult
import com.dee.home.common.MovieListRequest
import com.dee.home.common.MovieListResponse
import com.dee.home.topratedmovies.data.TopRatedMoviesDataSource

/**
 * Created by Hein Htet
 */
class TopRatedMoviesRepository(private val dataSource: TopRatedMoviesDataSource) :
    BaseRemoteRepository<MovieListRequest, MovieListResponse>() {

    override suspend fun process(params: MovieListRequest?): NetworkResult<MovieListResponse> {
        return dataSource.getTopRatedMovies(params)
    }
}