package com.example.charactersproject.model

data class DataHero(
    val id: Int,
    val imageUrl: String,
    val name: String,
    val listHeroShow: ArrayList<HeroShow>
)

data class HeroShow(

    val title: String,
    val list: ArrayList<String>
//    val allies: List<String>,
//    val enemies: List<String>,
//    val films: List<String>,
//    val parkAttractions: List<String>,
//    val shortFilms: List<String>,
//    val tvShows: List<String>,
//    val videoGames: List<String>
)
