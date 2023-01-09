package com.example.charactersproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MyDisneyHero(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "image")
    val image: String,

    @ColumnInfo(name = "idHero")
    val idHero: String
)
