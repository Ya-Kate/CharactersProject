package com.example.charactersproject

import android.app.Application
import com.example.charactersproject.di.ApplicationComponent
import com.example.charactersproject.di.ApplicationModule
import com.example.charactersproject.network.Network

class App : Application() {
    companion object {
        lateinit var appComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent
            .builder()
            .networkModule(Network())
            .applicationModule(ApplicationModule(this.applicationContext))
            .build()
    }
}