package com.dee.home

import com.dee.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Hein Htet
 */
val homeViewModelModule = module {
    viewModel { HomeViewModel(get(),get(),get(),get(),get()) }
}