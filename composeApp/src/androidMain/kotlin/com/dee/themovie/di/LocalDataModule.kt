package com.dee.themovie.di

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.dee.localdata.LocalDataManager
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by Hein Htet
 */

val localDataModule = module {
    single {
        LocalDataManager(
            getEncryptedSharePreference(
                applicationContext = androidApplication(),
                name = "APP_KMM_SHARE_PREF"
            )
        )
    }
}
fun getEncryptedSharePreference(applicationContext: Context, name : String): SharedPreferences {
    val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    return EncryptedSharedPreferences.create(
        name,
        masterKeyAlias,
        applicationContext,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )
}