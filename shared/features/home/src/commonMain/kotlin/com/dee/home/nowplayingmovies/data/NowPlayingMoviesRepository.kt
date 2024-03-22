package com.dee.home.nowplayingmovies.data

import com.dee.network.BaseRemoteRepository
import com.dee.network.NetworkResult
import com.dee.home.common.MovieListRequest
import com.dee.home.common.MovieListResponse

/**
 * Created by Hein Htet
 */
class NowPlayingMoviesRepository(private val dataSource: NowPlayingMoviesDataSource) :
    BaseRemoteRepository<MovieListRequest, MovieListResponse>() {

    override suspend fun process(params: MovieListRequest?): NetworkResult<MovieListResponse> {
        return dataSource.getNowPlayingMovies(params)
    }
}