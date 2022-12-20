package com.example.charactersproject.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Singleton
object MyDisneyHeroDataBase {
    @Provides
    fun provideDB(context: Context): AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java, "database-name"
        ).build()
    }

    @Provides
    fun provideMyDisneyHeroDao(appDataBase: AppDataBase): MyDisneyHeroDao {
        return appDataBase.myDisneyHeroDao()
    }
}