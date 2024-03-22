package com.dee.details.data

import com.dee.appcommon.Constants.API_KEY
import com.dee.appcommon.Constants.QUERY_API_KEY
import com.dee.network.NetworkResult
import com.dee.network.safeRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.client.request.url

/**
 * Created by Hein Htet
 */
class MovieDetailsApiService(private val httpClient: HttpClient) {


    suspend fun fetchMovieDetails(id: String): NetworkResult<MovieDetailsResponse> {
        return httpClient.safeRequest {
            url(PATH.plus(id))
            parameter(QUERY_API_KEY, API_KEY)

        }
    }

    companion object {
        const val PATH = "movie/"
    }

}