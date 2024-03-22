package com.dee.details.data

import com.dee.network.BaseRemoteRepository
import com.dee.network.NetworkResult


/**
 * Created by Hein Htet
 */
class MovieDetailsRepository(private val dataSource: MovieDetailsDataSource) :
    BaseRemoteRepository<String, MovieDetailsResponse>() {
    override suspend fun process(params: String?): NetworkResult<MovieDetailsResponse> {
        return dataSource.getMovieDetails(params.orEmpty())
    }
}