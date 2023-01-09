package com.example.charactersproject.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class Network {
    @Provides
    fun getHeroFactApi(): DisneyHeroApi {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.disneyapi.dev")
            .client(OkHttpClient.Builder().addInterceptor(loggingInterceptor).build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(DisneyHeroApi::class.java)
    }
}