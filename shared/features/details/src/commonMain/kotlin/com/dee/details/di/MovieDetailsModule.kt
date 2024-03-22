package com.dee.details.di

import com.dee.details.data.MovieDetailsApiService
import com.dee.details.data.MovieDetailsDataSource
import com.dee.details.data.MovieDetailsRepository
import com.dee.details.domain.MovieDetailsDisplayMapper
import com.dee.details.domain.MovieDetailsUseCase
import com.dee.details.presentation.MovieDetailsViewModel
import org.koin.dsl.module

/**
 * Created by Hein Htet
 */

val movieDetailsModule = module {
    single<MovieDetailsApiService> { MovieDetailsApiService(get()) }
    single<MovieDetailsDataSource> { MovieDetailsDataSource(get()) }
    single<MovieDetailsRepository> { MovieDetailsRepository(get()) }
    single<MovieDetailsDisplayMapper> { MovieDetailsDisplayMapper() }
    single<MovieDetailsUseCase> { MovieDetailsUseCase(get(),get()) }
    single<MovieDetailsViewModel> { MovieDetailsViewModel(get()) }
}