package com.dee.themovie

import android.app.Application
import com.dee.themovie.di.localDataModule
import com.dee.themovie.di.viewModelModules
import com.jakewharton.threetenabp.AndroidThreeTen
import di.sharedModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Hein Htet
 */
class TheMovieApp : Application() {
    override fun onCreate() {
        super.onCreate()
            initKoin()
        AndroidThreeTen.init(this)
    }

    private fun initKoin() {
        val appModules = localDataModule + sharedModules + viewModelModules
        startKoin {
            androidContext(this@TheMovieApp)
            modules(appModules)
        }
    }
}