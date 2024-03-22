package com.dee.home

import com.dee.home.common.MovieListDisplayMapper
import com.dee.home.nowplayingmovies.data.NowMoviesApiService
import com.dee.home.nowplayingmovies.data.NowPlayingMoviesDataSource
import com.dee.home.nowplayingmovies.data.NowPlayingMoviesRepository
import com.dee.home.nowplayingmovies.domain.NowPlayingMoviesUseCase
import com.dee.home.popularmovies.data.PopularMoviesApiService
import com.dee.home.popularmovies.data.PopularMoviesDataSource
import com.dee.home.popularmovies.data.PopularMoviesRepository
import com.dee.home.popularmovies.domain.PopularMoviesUseCase
import com.dee.home.presentation.HomeViewModel
import com.dee.home.topratedmovies.data.TopRatedMoviesApiService
import com.dee.home.topratedmovies.data.TopRatedMoviesDataSource
import com.dee.home.topratedmovies.data.TopRatedMoviesRepository
import com.dee.home.topratedmovies.domain.TopRatedMoviesUseCase
import com.dee.home.tradingmovies.data.TrendingMoviesApiService
import com.dee.home.tradingmovies.data.TrendingMoviesDataSource
import com.dee.home.tradingmovies.data.TrendingMoviesRepository
import com.dee.home.tradingmovies.domain.TradingMoviesUseCase
import com.dee.home.upmovies.data.UpcomingMoviesApiService
import com.dee.home.upmovies.data.UpcomingMoviesDataSource
import com.dee.home.upmovies.data.UpcomingMoviesRepository
import com.dee.home.upmovies.domain.UpcomingMoviesUseCase
import com.dee.network.provideHttpClient
import io.ktor.client.HttpClient
import org.koin.dsl.module

/**
 * Created by Hein Htet
 */

val homeModule = module {
    single<NowMoviesApiService> { NowMoviesApiService(get<HttpClient>()) }
    single<NowPlayingMoviesDataSource> { NowPlayingMoviesDataSource(get<NowMoviesApiService>()) }
    single<NowPlayingMoviesRepository> { NowPlayingMoviesRepository(get<NowPlayingMoviesDataSource>()) }
    single<NowPlayingMoviesUseCase> { NowPlayingMoviesUseCase(get(),get()) }
    single<MovieListDisplayMapper> { MovieListDisplayMapper() }
    single<PopularMoviesApiService> { PopularMoviesApiService(get()) }
    single<PopularMoviesDataSource> { PopularMoviesDataSource(get()) }
    single<PopularMoviesRepository> { PopularMoviesRepository(get()) }
    single<PopularMoviesUseCase> { PopularMoviesUseCase(get(),get()) }
    single<TopRatedMoviesApiService> { TopRatedMoviesApiService(get()) }
    single<TopRatedMoviesDataSource> { TopRatedMoviesDataSource(get()) }
    single<TopRatedMoviesRepository> { TopRatedMoviesRepository(get()) }
    single<TopRatedMoviesUseCase> { TopRatedMoviesUseCase(get(),get()) }
    single<TrendingMoviesApiService> { TrendingMoviesApiService(get()) }
    single<TrendingMoviesDataSource> { TrendingMoviesDataSource(get()) }
    single<TrendingMoviesRepository> { TrendingMoviesRepository(get()) }
    single<TradingMoviesUseCase> { TradingMoviesUseCase(get(),get()) }
    single<UpcomingMoviesApiService> { UpcomingMoviesApiService(get()) }
    single<UpcomingMoviesDataSource> { UpcomingMoviesDataSource(get()) }
    single<UpcomingMoviesRepository> { UpcomingMoviesRepository(get()) }
    single<UpcomingMoviesUseCase> { UpcomingMoviesUseCase(get(),get()) }
    single<HomeViewModel> { HomeViewModel(get(),get(),get(),get(),get()) }
}
