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
)
