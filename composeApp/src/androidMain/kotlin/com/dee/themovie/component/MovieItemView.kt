package com.dee.themovie.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dee.themovie.theme.Text10Bold
import com.dee.themovie.theme.Text12Bold
import com.dee.home.common.MovieItemDisplay

/**
 * Created by Hein Htet
 */

@Composable
fun MovieItemView(
    modifier: Modifier = Modifier,
    item: MovieItemDisplay = MovieItemDisplay(),
    showTitle : Boolean = true,
    ratingProgressSize : Int = 40,
    onItemClick: (movie: MovieItemDisplay) -> Unit = {},
) {
    Column(
        modifier = modifier.width(170.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onItemClick(item) }
            .padding(8.dp)
    ) {
        Box {
            Card {
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    AsyncImage(
                        model = item.imageUrl,
                        contentDescription = item.title,
                        modifier = Modifier,
                        contentScale = ContentScale.Crop
                    )
                }
            }
            MovieRatingView(
                modifier = Modifier,
                ratingLabel = item.ratingLabel,
                ratingPercent = item.rating,
                size = ratingProgressSize
            )
        }
        Spacer(Modifier.padding(top = 22.dp))
        if(showTitle) {
            Text12Bold(
                text = item.title,
                textStyle = MaterialTheme.typography.titleMedium,
                maxLine = 2
            )
            Spacer(Modifier.padding(top = 4.dp))
            Text10Bold(
                text = item.releasedDate,
                textStyle = MaterialTheme.typography.labelSmall.copy(color = Color.Gray)
            )
        }
    }
}