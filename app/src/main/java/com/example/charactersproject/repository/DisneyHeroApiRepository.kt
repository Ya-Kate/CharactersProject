package com.example.charactersproject.repository

import com.example.charactersproject.Data
import com.example.charactersproject.model.DisneyHeroListResponse
import com.example.charactersproject.network.DisneyHeroFactApi
import com.example.charactersproject.network.Network
import retrofit2.Response
import javax.inject.Inject

class DisneyHeroApiRepository @Inject constructor(private val api: DisneyHeroFactApi) {

    private val network = Network()

    suspend fun getHeroFactApi(page: Int, limit: Int): Response<DisneyHeroListResponse> {
        return network.getHeroFactApi().getFact(page, limit)
    }

    suspend fun getImageDinneyHero(idImage: String): Response<Data> {
        return network.getHeroFactApi().getOneCharacher(idImage)
    }

}