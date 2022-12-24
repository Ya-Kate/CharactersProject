package com.example.charactersproject

import android.app.Application
import android.content.Context
import com.example.charactersproject.ui.di.appModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(appModule))
            androidContext(androidContext = this@App)
        }
    }
}