package com.dee.themovie.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dee.themovie.component.MovieItemView
import com.dee.themovie.component.Screen
import com.dee.themovie.theme.Text12Medium
import com.dee.themovie.theme.Text14Medium
import com.dee.themovie.theme.Text16Medium
import com.dee.details.presentation.MovieDetailsViewModel
import com.dee.home.common.MovieItemDisplay
import org.koin.androidx.compose.getViewModel

/**
 * Created by Hein Htet
 */


@Composable
fun MovieDetailsScreen(movieId: String?, viewModel: MovieDetailsViewModel = getViewModel()) {
    val movieDetails = viewModel.outputs.movieDetails.collectAsState()
    DisposableEffect(key1 = movieId) {
        viewModel.inputs.onGetMovieDetails(movieId.orEmpty())
        onDispose { }
    }
    Screen(vm = viewModel) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            movieDetails.value?.let { details ->
                AsyncImage(
                    model = details.backdropImageUrl,
                    contentDescription = details.title,
                    modifier = Modifier.fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .offset(
                            y = (-150).dp
                        )
                ) {
                    Row {
                        MovieItemView(
                            modifier = Modifier,
                            showTitle = false,
                            ratingProgressSize = 50,
                            item = MovieItemDisplay(
                                imageUrl = details.posterImageUrl,
                                releasedDate = details.releasedDate,
                                id = details.id,
                                ratingLabel = details.ratingLabel,
                                rating = details.rating,
                            )
                        )
                        Column(modifier = Modifier.padding(top = 155.dp, start = 6.dp)) {
                            Text16Medium(text = details.title)
                            Text12Medium(text = details.releasedDate)
                            Text12Medium(text = "•".plus(details.genres), textStyle = TextStyle(color = MaterialTheme.colorScheme.primary))
                            Text12Medium(text = "•".plus(details.duration), textStyle = TextStyle(color = Color.Gray))
                        }
                    }
                    Text14Medium(text = details.description, modifier = Modifier.padding(horizontal = 16.dp))
                }
            }
        }
    }
}