package com.example.charactersproject.utils

import com.example.charactersproject.Data
import com.example.charactersproject.model.DataHero
import com.example.charactersproject.model.HeroShow

fun Data.toDataHero(): DataHero {
    val list = arrayListOf<HeroShow>()

    if (allies.isNotEmpty()) {
        list.add(HeroShow("Title", allies))
    }
    if (enemies.isNotEmpty()) {
        list.add(HeroShow("Enemies", enemies))
    }
    if (films.isNotEmpty()) {
        list.add(HeroShow("Films", films))
    }
    if (parkAttractions.isNotEmpty()) {
        list.add(HeroShow("ParkAttractions", parkAttractions))
    }
    if (shortFilms.isNotEmpty()) {
        list.add(HeroShow("ShortFilms", shortFilms))
    }
    if (tvShows.isNotEmpty()) {
        list.add(HeroShow("TVShows", tvShows))
    }
    if (videoGames.isNotEmpty()) {
        list.add(HeroShow("VideoGames", videoGames))
    }

    return DataHero(id, imageUrl, name, list)
}