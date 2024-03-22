package com.dee.home.common

import com.dee.appcommon.Constants
import com.dee.appcommon.Constants.DATE_API_FORMAT_01
import com.dee.appcommon.Constants.DATE_FORMAT_01
import com.dee.common.formatDecimal
import com.dee.common.getFormattedDate
import com.dee.network.Mapper

/**
 * Created by Hein Htet
 */
class MovieListDisplayMapper : Mapper<List<MovieItemResponse>, List<MovieItemDisplay>> {
    override fun toUI(param: List<MovieItemResponse>): List<MovieItemDisplay> {
        return param.map {
            MovieItemDisplay(
                id = it.id ?: 0,
                title = it.title.orEmpty(),
                imageUrl = Constants.IMAGE_PATH.plus(it.posterPath),
                releasedDate = getFormattedDate(
                    it.releaseDate.orEmpty(),
                    DATE_API_FORMAT_01,
                    DATE_FORMAT_01
                ),
                rating = ((it.voteAverage ?: 1).toFloat()) / 10,
                ratingLabel = (it.voteAverage ?: 0.0).formatDecimal(1)
            )
        }
    }
}