package com.example.charactersproject

data class DataCharacter(
    val count: Int,
    val data: List<Data>,
    val nextPage: String,
    val totalPages: Int
)

data class Data(
    val id: Int,
    val allies: List<Any>,
    val enemies: List<Any>,
    val films: List<String>,
    val imageUrl: String,
    val name: String,
    val parkAttractions: List<String>,
    val shortFilms: List<String>,
    val tvShows: List<String>,
    val url: String,
    val videoGames: List<String>
)
