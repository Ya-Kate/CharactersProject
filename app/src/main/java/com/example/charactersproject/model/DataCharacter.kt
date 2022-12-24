package com.example.charactersproject

import com.google.gson.annotations.SerializedName

data class DataCharacter(
    val count: Int,
    val data: List<Data>,
    val nextPage: String,
    val totalPages: Int
)

data class Data(
    @SerializedName("_id")
    val id: Int,
    val allies: ArrayList<String>,
    val enemies: ArrayList<String>,
    val films: ArrayList<String>,
    val imageUrl: String,
    val name: String,
    val parkAttractions: ArrayList<String>,
    val shortFilms: ArrayList<String>,
    val tvShows: ArrayList<String>,
    val url: String,
    val videoGames: ArrayList<String>
)
