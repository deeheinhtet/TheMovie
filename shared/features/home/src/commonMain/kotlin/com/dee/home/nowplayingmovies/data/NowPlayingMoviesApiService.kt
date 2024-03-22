package com.dee.home.nowplayingmovies.data

import com.dee.appcommon.Constants.API_KEY
import com.dee.appcommon.Constants.QUERY_API_KEY
import com.dee.appcommon.Constants.QUERY_LANGUAGE
import com.dee.appcommon.Constants.QUERY_PAGE
import com.dee.network.NetworkResult
import com.dee.network.safeRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import com.dee.home.common.MovieListRequest
import com.dee.home.common.MovieListResponse

/**
 * Created by Hein Htet
 */
class NowMoviesApiService(private val httpClient: HttpClient) {

    suspend fun fetchNowPlayingMovies(request: MovieListRequest? = MovieListRequest(page = 1)): NetworkResult<MovieListResponse> {
        return httpClient.safeRequest<MovieListResponse> {
            url(PATH)
            parameter(QUERY_PAGE, request?.page)
            parameter(QUERY_LANGUAGE, request?.language)
            parameter(QUERY_API_KEY, API_KEY)
        }
    }

    companion object {
        const val PATH = "movie/now_playing"
    }
}