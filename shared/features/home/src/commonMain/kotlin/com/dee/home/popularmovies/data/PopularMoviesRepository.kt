package com.dee.home.popularmovies.data

import com.dee.network.BaseRemoteRepository
import com.dee.network.NetworkResult
import com.dee.home.common.MovieListRequest
import com.dee.home.common.MovieListResponse

/**
 * Created by Hein Htet
 */
class PopularMoviesRepository(private val dataSource: PopularMoviesDataSource) :
    BaseRemoteRepository<MovieListRequest, MovieListResponse>() {

    override suspend fun process(params: MovieListRequest?): NetworkResult<MovieListResponse> {
        return dataSource.getPopularMovies(params)
    }
}