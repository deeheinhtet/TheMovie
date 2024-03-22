package com.dee.home.common

import com.dee.appcommon.Constants.DEFAULT_LANGUAGE

/**
 * Created by Hein Htet
 */

data class MovieListRequest(
    val page: Int,
    val language: String = DEFAULT_LANGUAGE,
    val trendingType: TrendingType? = null,
)


enum class TrendingType(val param: String) {
    TODAY("day"),
    WEEK("week");

    companion object {
        fun fromParam(id: String): TrendingType {
            return when (id) {
                TODAY.param -> TODAY
                WEEK.param -> WEEK
                else -> TODAY
            }
        }
    }
}