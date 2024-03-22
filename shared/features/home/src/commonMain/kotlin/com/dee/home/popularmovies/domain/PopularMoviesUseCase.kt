package com.dee.home.popularmovies.domain

import com.dee.network.BaseUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.dee.home.common.MovieItemDisplay
import com.dee.home.common.MovieListDisplayMapper
import com.dee.home.common.MovieListRequest
import com.dee.home.popularmovies.data.PopularMoviesRepository

/**
 * Created by Hein Htet
 */
class PopularMoviesUseCase(
    private val repository: PopularMoviesRepository,
    private val popularMoviesMapper: MovieListDisplayMapper
) :
    BaseUseCase<MovieListRequest, List<MovieItemDisplay>>() {
    override suspend fun invoke(params: MovieListRequest): Flow<List<MovieItemDisplay>> = flow {
        repository.process(params).handleNetworkResult {
            emit(popularMoviesMapper.toUI(it.results))
        }
    }
}