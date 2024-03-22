package com.dee.home.topratedmovies.domain

import com.dee.network.BaseUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.dee.home.common.MovieItemDisplay
import com.dee.home.common.MovieListDisplayMapper
import com.dee.home.common.MovieListRequest
import com.dee.home.topratedmovies.data.TopRatedMoviesRepository

/**
 * Created by Hein Htet
 */
class TopRatedMoviesUseCase(
    private val repository: TopRatedMoviesRepository,
    private val moviesMapper: MovieListDisplayMapper
) :
    BaseUseCase<MovieListRequest, List<MovieItemDisplay>>() {
    override suspend fun invoke(params: MovieListRequest): Flow<List<MovieItemDisplay>> = flow {
        repository.process(params).handleNetworkResult {
            emit(moviesMapper.toUI(it.results))
        }
    }
}