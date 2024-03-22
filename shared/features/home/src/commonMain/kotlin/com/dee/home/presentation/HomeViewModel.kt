package com.dee.home.presentation

import com.dee.core.BaseViewModel
import com.dee.common.mapToErrorDisplay
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import com.dee.home.common.MovieItemDisplay
import com.dee.home.common.MovieListRequest
import com.dee.home.common.TrendingType
import com.dee.home.nowplayingmovies.domain.NowPlayingMoviesUseCase
import com.dee.home.popularmovies.domain.PopularMoviesUseCase
import com.dee.home.tradingmovies.domain.TradingMoviesUseCase
import com.dee.home.topratedmovies.domain.TopRatedMoviesUseCase
import com.dee.home.upmovies.domain.UpcomingMoviesUseCase

/**
 * Created by Hein Htet
 */
class HomeViewModel(
    private val popularMoviesUseCase: PopularMoviesUseCase,
    private val tradingMoviesUseCase: TradingMoviesUseCase,
    private val nowPlayingMoviesUseCase: NowPlayingMoviesUseCase,
    private val upcomingMoviesUseCase: UpcomingMoviesUseCase,
    private val topRatedMoviesUseCase: TopRatedMoviesUseCase,
) : BaseViewModel() {

    private val _popularMovies = MutableStateFlow<List<MovieItemDisplay>>(emptyList())
    private val _nowPlayingMovies = MutableStateFlow<List<MovieItemDisplay>>(emptyList())
    private val _trendingMovies = MutableStateFlow<List<MovieItemDisplay>>(emptyList())
    private val _upcomingMovies = MutableStateFlow<List<MovieItemDisplay>>(emptyList())
    private val _topRatedMovies = MutableStateFlow<List<MovieItemDisplay>>(emptyList())
    private var _currentSelectedTradingMovieType = TrendingType.TODAY

    override val inputs = BrewInputs()
    override val outputs = BrewOutputs()

    inner class BrewInputs : BaseInputs() {
        fun onGetPopularMovies() = getPopularMovies()

        fun onUpdateTradingMovieType(type: TrendingType) {
            _currentSelectedTradingMovieType = type
            getTradingMovies()
        }
    }

    init {
        getPopularMovies()
        getTradingMovies()
        getNowPlayingMovies()
        getUpcomingMovies()
        getTopRatedMovies()
    }


    inner class BrewOutputs : BaseOutputs() {

        val popularMovies: StateFlow<List<MovieItemDisplay>>
            get() = _popularMovies

        val trendingMovies: StateFlow<List<MovieItemDisplay>>
            get() = _trendingMovies

        val nowPlayingMovies: StateFlow<List<MovieItemDisplay>>
            get() = _nowPlayingMovies

        val upcomingMovies: StateFlow<List<MovieItemDisplay>>
            get() = _upcomingMovies

        val topRatedMovies: StateFlow<List<MovieItemDisplay>>
            get() = _topRatedMovies

    }


    private fun getPopularMovies() {
        scope.launch {
            popularMoviesUseCase(params = MovieListRequest(page = 1))
                .catch {
                    inputs.emitError(it.mapToErrorDisplay())
                }
                .onStart { inputs.emitLoading(true) }
                .onCompletion { inputs.emitLoading(false) }
                .collectLatest {
                    _popularMovies.value = it
                }
        }
    }

    private fun getNowPlayingMovies() {
        scope.launch {
            nowPlayingMoviesUseCase(params = MovieListRequest(page = 1))
                .catch {
                    inputs.emitError(it.mapToErrorDisplay())
                }
                .onStart { inputs.emitLoading(true) }
                .onCompletion { inputs.emitLoading(false) }
                .collectLatest {
                    _nowPlayingMovies.value = it
                }
        }
    }

    private fun getTradingMovies() {
        scope.launch {
            tradingMoviesUseCase(
                params = MovieListRequest(
                    page = 1,
                    trendingType = _currentSelectedTradingMovieType
                )
            )
                .catch {
                    inputs.emitError(it.mapToErrorDisplay())
                }
                .onStart { inputs.emitLoading(true) }
                .onCompletion { inputs.emitLoading(false) }
                .collectLatest {
                    _trendingMovies.value = it
                }
        }
    }

    private fun getUpcomingMovies() {
        scope.launch {
            upcomingMoviesUseCase(
                params = MovieListRequest(
                    page = 1,
                    trendingType = _currentSelectedTradingMovieType
                )
            )
                .catch {
                    inputs.emitError(it.mapToErrorDisplay())
                }
                .onStart { inputs.emitLoading(true) }
                .onCompletion { inputs.emitLoading(false) }
                .collectLatest {
                    _upcomingMovies.value = it
                }
        }
    }

    private fun getTopRatedMovies() {
        scope.launch {
            topRatedMoviesUseCase(
                params = MovieListRequest(
                    page = 1,
                    trendingType = _currentSelectedTradingMovieType
                )
            )
                .catch {
                    inputs.emitError(it.mapToErrorDisplay())
                }
                .onStart { inputs.emitLoading(true) }
                .onCompletion { inputs.emitLoading(false) }
                .collectLatest {
                    _topRatedMovies.value = it
                }
        }
    }
}