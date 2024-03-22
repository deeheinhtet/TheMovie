package com.dee.details.data

import com.dee.network.NetworkResult


/**
 * Created by Hein Htet
 */
class MovieDetailsDataSource(private val apiService: MovieDetailsApiService) {


    suspend fun getMovieDetails(id: String): NetworkResult<MovieDetailsResponse> {
        return apiService.fetchMovieDetails(id)
    }
}