package com.example.charactersproject.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class Network {

    @Provides
    @Singleton
    fun getHeroFactApi() : DisneyHeroFactApi {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.disneyapi.dev")
            .client(OkHttpClient.Builder().addInterceptor (loggingInterceptor).build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(DisneyHeroFactApi::class.java)
    }

//    @Provides
//    fun getMyHeroFactApi() : MyDisneyHeroFactApi {
//
//        val loggingInterceptor = HttpLoggingInterceptor()
//        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://api.disneyapi.dev")
//            .client(OkHttpClient.Builder().addInterceptor (loggingInterceptor).build())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        return retrofit.create(MyDisneyHeroFactApi::class.java)
//    }

}