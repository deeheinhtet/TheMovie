package com.dee.details.domain

import com.dee.appcommon.Constants
import com.dee.appcommon.Constants.DATE_API_FORMAT_01
import com.dee.appcommon.Constants.DATE_FORMAT_01
import com.dee.common.formatDecimal
import com.dee.common.formatDuration
import com.dee.common.getFormattedDate
import com.dee.details.data.MovieDetailsResponse
import com.dee.network.Mapper
import modules.moviedetails.domain.MovieDetailsDisplay

/**
 * Created by Hein Htet
 */
class MovieDetailsDisplayMapper :
    Mapper<MovieDetailsResponse, MovieDetailsDisplay> {
    override fun toUI(param: MovieDetailsResponse): MovieDetailsDisplay {
        return MovieDetailsDisplay(
            id = param.id ?: 0,
            title = param.title.orEmpty(),
            backdropImageUrl = Constants.BACKDROP_IMAGE_PATH.plus(param.backdropPath),
            posterImageUrl = Constants.IMAGE_PATH.plus(param.posterPath),
            releasedDate = getFormattedDate(
                param.releaseDate.orEmpty(),
                DATE_API_FORMAT_01,
                DATE_FORMAT_01
            ),
            rating = ((param.voteAverage ?: 1).toFloat()) / 10,
            ratingLabel = (param.voteAverage ?: 0.0).formatDecimal(1),
            description = param.overview.orEmpty(),
            genres = param.genres.map { it.name }.joinToString(","),
            duration = param.runtime?.formatDuration() ?: "0"
        )
    }
}