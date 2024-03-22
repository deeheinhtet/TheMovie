package com.dee.themovie.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dee.themovie.R
import com.dee.themovie.component.HorizontalListMoviesView
import com.dee.themovie.component.Screen
import com.dee.themovie.main.LocalNavController
import com.dee.themovie.main.Screens
import com.dee.home.presentation.HomeViewModel
import com.dee.home.presentation.ToggleSelectionModel
import com.dee.home.common.TrendingType
import org.koin.androidx.compose.getViewModel

/**
 * Created by Hein Htet
 */

@Composable
fun HomePage( viewModel: HomeViewModel = getViewModel()) {
    Screen(vm = viewModel, onRetry = { viewModel.inputs.onGetPopularMovies() }) {

        val navController = LocalNavController.current


        val popularMovies = viewModel.outputs.popularMovies.collectAsState()
        val tradingMovies = viewModel.outputs.trendingMovies.collectAsState()
        val nowPlayingMovies = viewModel.outputs.nowPlayingMovies.collectAsState()
        val upcomingMovies = viewModel.outputs.upcomingMovies.collectAsState()
        val topRatedMovies = viewModel.outputs.topRatedMovies.collectAsState()
        val context = LocalContext.current
        val items = listOf(
            ToggleSelectionModel(
                title = context.getString(R.string.LABEL_TODAY),
                isSelected = true,
                TrendingType.TODAY.param
            ),
            ToggleSelectionModel(
                title = context.getString(R.string.LABEL_THIS_WEEK),
                isSelected = false,
                TrendingType.WEEK.param
            )
        )
        val toggleSelections = rememberSaveable {
            mutableStateOf(items)
        }


        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            if (tradingMovies.value.isNotEmpty()) {
                HorizontalListMoviesView(
                    modifier = Modifier.padding(top = 16.dp),
                    headerTitle = stringResource(R.string.LABEL_TRENDING),
                    toggleSelections = toggleSelections.value,
                    movies = tradingMovies.value,
                    onToggleItemClick = { item ->
                        toggleSelections.value = items.map {
                            it.isSelected = item.title == it.title
                            it
                        }
                        viewModel.inputs.onUpdateTradingMovieType(TrendingType.fromParam(item.id))
                    },
                    onItemClick = {
                        navController.navigate(Screens.Details.route.plus("${it.id}").plus("/").plus(it.title))
                    }
                )
            }
            if (nowPlayingMovies.value.isNotEmpty()) {
                HorizontalListMoviesView(
                    headerTitle = stringResource(R.string.NOW_PLAYING_MOVIES),
                    movies = nowPlayingMovies.value,
                    onItemClick = {
                        navController.navigate(Screens.Details.route.plus("${it.id}").plus("/").plus(it.title))
                    }
                )
            }
            if (popularMovies.value.isNotEmpty()) {
                HorizontalListMoviesView(
                    headerTitle = stringResource(R.string.POPULAR_MOVIES),
                    movies = popularMovies.value,
                    onItemClick = {
                        navController.navigate(Screens.Details.route.plus("${it.id}").plus("/").plus(it.title))
                    }
                )
            }
            if (topRatedMovies.value.isNotEmpty()) {
                HorizontalListMoviesView(
                    headerTitle = stringResource(R.string.TOP_RATED_MOVIES),
                    movies = topRatedMovies.value,
                    onItemClick = {
                        navController.navigate(Screens.Details.route.plus("${it.id}").plus("/").plus(it.title))
                    }
                )
            }
            if (upcomingMovies.value.isNotEmpty()) {
                HorizontalListMoviesView(
                    headerTitle = stringResource(R.string.UPCOMING_MOVIES),
                    movies = upcomingMovies.value,
                    onItemClick = {
                        navController.navigate(Screens.Details.route.plus("${it.id}").plus("/").plus(it.title))
                    }
                )
            }
        }
    }
}