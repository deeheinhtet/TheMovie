package com.dee.themovie.di

import com.dee.details.presentation.MovieDetailsViewModel
import com.dee.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Hein Htet
 */

val viewModelModules = module {
    viewModel { HomeViewModel(get(),get(),get(),get(),get()) }
    viewModel { MovieDetailsViewModel(get()) }
}