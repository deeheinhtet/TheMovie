package com.dee.themovie.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dee.themovie.theme.Text10

/**
 * Created by Hein Htet
 */

@Composable
fun BoxScope.MovieRatingView(
    modifier: Modifier,
    size: Int = 20,
    ratingLabel: String,
    ratingPercent: Float,
) {
    Card(
        shape = RoundedCornerShape((size / 2).dp),
        modifier = modifier.size(size.dp)
            .align(Alignment.BottomStart)
            .offset(x = 8.dp, y = (size / 2).dp)
            .padding(4.dp),
        colors = CardDefaults.cardColors().copy(
            containerColor = Color.Black
        )
    ) {
        Box(
            modifier = Modifier
                .padding(2.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                progress = { ratingPercent },
                trackColor = Color.Black,
                color = if (ratingPercent >= 0.6) Color.Green else Color.Yellow,
                strokeWidth = 1.dp
            )
            Text10(
                text = ratingLabel,
                modifier = Modifier.padding(horizontal = 4.dp)
                    .align(Alignment.Center),
                textStyle = TextStyle(
                    fontSize = 8.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Thin
                )
            )
        }
    }
}