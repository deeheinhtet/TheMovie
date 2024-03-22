package com.dee.home.common

/**
 * Created by Hein Htet
 */
data class MovieItemDisplay(
    val id: Int = 0,
    val title: String = "",
    val imageUrl : String = "",
    val releasedDate : String = "",
    val rating : Float = 0f,
    val ratingLabel : String = "0",
)