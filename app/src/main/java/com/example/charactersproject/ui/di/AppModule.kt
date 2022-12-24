package com.example.charactersproject.ui.di

import com.example.charactersproject.network.DisneyHeroFactApi
import com.example.charactersproject.repository.DisneyHeroApiRepository
import com.example.charactersproject.repository.SharedPreferenceRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {


    single<DisneyHeroFactApi> {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.disneyapi.dev")
            .client(OkHttpClient.Builder().addInterceptor(loggingInterceptor).build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(DisneyHeroFactApi::class.java)
    }

    single {
        SharedPreferenceRepository(
            context = get()
        )
    }

    factory<DisneyHeroApiRepository> {
        DisneyHeroApiRepository(
            api = get(),
            myDisneyHeroDao = get()
        )
    }

}





