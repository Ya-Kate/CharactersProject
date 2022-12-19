package com.example.charactersproject.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.charactersproject.model.MyDisneyHero

@Database(entities = [MyDisneyHero::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun myDisneyHeroDao(): MyDisneyHeroDao
}