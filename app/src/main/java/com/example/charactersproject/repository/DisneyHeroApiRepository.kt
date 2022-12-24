package com.example.charactersproject.repository

import com.example.charactersproject.Data
import com.example.charactersproject.db.MyDisneyHeroDao
import com.example.charactersproject.model.DisneyHeroListResponse
import com.example.charactersproject.model.MyDisneyHero
import com.example.charactersproject.network.DisneyHeroFactApi
import retrofit2.Response

class DisneyHeroApiRepository(
    private val api: DisneyHeroFactApi,
    private val myDisneyHeroDao: MyDisneyHeroDao
) {

    suspend fun getHeroFactApi(page: Int, limit: Int): Response<DisneyHeroListResponse> {
        return api.getFact(page, limit)
    }

    suspend fun getImageDisneyHero(idImage: String): Response<Data> {
        return api.getOneCharacher(idImage)
    }


    suspend fun addMyDisneyHero(myDisneyHero: MyDisneyHero) {
        myDisneyHeroDao.insertMyDisneyHero(myDisneyHero)
    }

    suspend fun deleteMyDisneyHero(myDisneyHero: MyDisneyHero) {
        myDisneyHeroDao.deleteMyDisneyHero(myDisneyHero)
    }

    suspend fun getMyListDisneyHero(): ArrayList<MyDisneyHero> {
        return myDisneyHeroDao.selectAllMyDisneyHeroes() as ArrayList<MyDisneyHero>
    }

}