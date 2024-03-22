package com.dee.details.domain

import com.dee.network.BaseUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.dee.details.data.MovieDetailsRepository
import com.dee.details.domain.MovieDetailsDisplayMapper
import modules.moviedetails.domain.MovieDetailsDisplay

/**
 * Created by Hein Htet
 */
class MovieDetailsUseCase(private val repository: MovieDetailsRepository, private val movieDetailsDisplayMapper: MovieDetailsDisplayMapper) :
    BaseUseCase<String, MovieDetailsDisplay>() {
    override suspend fun invoke(params: String): Flow<MovieDetailsDisplay> = flow {
        repository.process(params).handleNetworkResult {
            emit(movieDetailsDisplayMapper.toUI(it))
        }
    }
}