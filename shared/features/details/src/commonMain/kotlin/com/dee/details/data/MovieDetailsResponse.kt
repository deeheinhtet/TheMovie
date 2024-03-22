package com.dee.details.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Hein Htet
 */


@Serializable
data class MovieDetailsResponse(
    @SerialName("adult") var adult: Boolean? = null,
    @SerialName("backdrop_path") var backdropPath: String? = null,
    @SerialName("budget") var budget: Int? = null,
    @SerialName("genres") var genres: ArrayList<GenresResponse> = arrayListOf(),
    @SerialName("homepage") var homepage: String? = null,
    @SerialName("id") var id: Int? = null,
    @SerialName("imdb_id") var imdbId: String? = null,
    @SerialName("original_language") var originalLanguage: String? = null,
    @SerialName("original_title") var originalTitle: String? = null,
    @SerialName("overview") var overview: String? = null,
    @SerialName("popularity") var popularity: Double? = null,
    @SerialName("poster_path") var posterPath: String? = null,
    @SerialName("production_companies") var productionCompanies: ArrayList<ProductionCompaniesResponse> = arrayListOf(),
    @SerialName("production_countries") var productionCountries: ArrayList<ProductionCompaniesResponse> = arrayListOf(),
    @SerialName("release_date") var releaseDate: String? = null,
    @SerialName("revenue") var revenue: Int? = null,
    @SerialName("runtime") var runtime: Int? = null,
    @SerialName("spoken_languages") var spokenLanguages: ArrayList<SpokenLanguages> = arrayListOf(),
    @SerialName("status") var status: String? = null,
    @SerialName("tagline") var tagline: String? = null,
    @SerialName("title") var title: String? = null,
    @SerialName("video") var video: Boolean? = null,
    @SerialName("vote_average") var voteAverage: Double? = null,
    @SerialName("vote_count") var voteCount: Int? = null,
)


@Serializable
data class GenresResponse(
    @SerialName("id") var id: Int? = null,
    @SerialName("name") var name: String? = null,
)

@Serializable
data class ProductionCompaniesResponse(
    @SerialName("id") var id: Int? = null,
    @SerialName("logo_path") var logoPath: String? = null,
    @SerialName("name") var name: String? = null,
    @SerialName("origin_country") var originCountry: String? = null,
)

@Serializable
data class SpokenLanguages(
    @SerialName("english_name") var englishName: String? = null,
    @SerialName("iso_639_1") var iso6391: String? = null,
    @SerialName("name") var name: String? = null,
)