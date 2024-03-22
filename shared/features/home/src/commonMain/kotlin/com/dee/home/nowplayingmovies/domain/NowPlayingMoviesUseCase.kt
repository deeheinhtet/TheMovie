package com.dee.home.nowplayingmovies.domain

import com.dee.home.common.MovieItemDisplay
import com.dee.network.BaseUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.dee.home.common.MovieListDisplayMapper
import com.dee.home.common.MovieListRequest
import com.dee.home.nowplayingmovies.data.NowPlayingMoviesRepository

/**
 * Created by Hein Htet
 */
class NowPlayingMoviesUseCase(
    private val repository: NowPlayingMoviesRepository,
    private val moviesMapper: MovieListDisplayMapper
) :
    BaseUseCase<MovieListRequest, List<MovieItemDisplay>>() {
    override suspend fun invoke(params: MovieListRequest): Flow<List<MovieItemDisplay>> = flow {
        repository.process(params).handleNetworkResult {
            emit(moviesMapper.toUI(it.results))
        }
    }
}