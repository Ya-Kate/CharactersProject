package com.example.charactersproject.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.charactersproject.model.MyDisneyHero

@Dao
interface MyDisneyHeroDao {

//    добавление элементов в список
    @Insert
    suspend fun insertMyDisneyHero (myDisneyHero:MyDisneyHero)

    @Delete
    suspend fun deleteMyDisneyHero (myDisneyHero: MyDisneyHero)

    // показать весь список
    @Query("SELECT * FROM MyDisneyHero")
    suspend fun selectAllMyDisneyHeroes() :List<MyDisneyHero>
}