package com.example.charactersproject.repository

import com.example.charactersproject.Data
import com.example.charactersproject.db.MyDisneyHeroDao
import com.example.charactersproject.model.DisneyHeroListResponse
import com.example.charactersproject.model.MyDisneyHero
import com.example.charactersproject.network.Network
import retrofit2.Response
import javax.inject.Inject

class DisneyHeroApiRepository @Inject constructor(
    private val myDisneyHeroDao: MyDisneyHeroDao
) {

    private val network = Network()

    suspend fun getHeroFactApi(page: Int, limit: Int): Response<DisneyHeroListResponse> {
        return network.getHeroFactApi().getFact(page, limit)
    }

    suspend fun getImageDisneyHero(idImage: String): Response<Data> {
        return network.getHeroFactApi().getOneDisneyHero(idImage)
    }


    suspend fun addMyDisneyHero(myDisneyHero: MyDisneyHero) {
        myDisneyHeroDao.insertMyDisneyHero(myDisneyHero)
    }

    suspend fun getMyListDisneyHero(): ArrayList<MyDisneyHero> {
        return myDisneyHeroDao.selectAllMyDisneyHeroes() as ArrayList<MyDisneyHero>
    }
}