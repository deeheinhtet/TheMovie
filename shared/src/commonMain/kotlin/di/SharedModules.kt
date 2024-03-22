package di

import com.dee.details.di.movieDetailsModule
import com.dee.home.common.MovieListDisplayMapper
import com.dee.home.homeModule
import com.dee.home.popularmovies.data.PopularMoviesApiService
import com.dee.home.popularmovies.data.PopularMoviesDataSource
import com.dee.home.popularmovies.data.PopularMoviesRepository
import com.dee.home.popularmovies.domain.PopularMoviesUseCase
import com.dee.home.presentation.HomeViewModel
import com.dee.network.networkModule
import org.koin.dsl.module

/**
 * Created by Hein Htet
 */


val sharedModules = listOf(
    networkModule,
    homeModule,
    movieDetailsModule,
)