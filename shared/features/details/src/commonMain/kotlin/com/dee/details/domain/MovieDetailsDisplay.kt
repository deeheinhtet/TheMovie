package modules.moviedetails.domain

/**
 * Created by Hein Htet
 */
data class MovieDetailsDisplay(
    val id: Int,
    val title: String,
    val backdropImageUrl: String,
    val posterImageUrl: String,
    val releasedDate : String,
    val rating : Float,
    val ratingLabel : String,
    val description : String,
    val genres : String,
    val duration : String
)