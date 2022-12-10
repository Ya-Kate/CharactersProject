package com.example.charactersproject.network

import com.example.charactersproject.Data
import com.example.charactersproject.model.DisneyHeroListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DisneyHeroFactApi {

    @GET("/characters")
    suspend fun getFact(
        @Query("page") page: Int,
        @Query("limit") limit: Int? = 100
    ): Response<DisneyHeroListResponse>

    @GET("/characters/{id}")
    suspend fun getOneCharacher(@Path("id") id: String): Response<Data>
}
