package com.example.charactersproject.network

import com.example.charactersproject.model.DissnayChararerListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DisnayCharacherFactApi {

    @GET("/characters")
    suspend fun getFact(
        @Query("page") page: Int,
        @Query("limit") limit: Int? = 100
    ): Response<DissnayChararerListResponse>

    @GET("/characters/:id")
    suspend fun getOneCharacher(id: String): Response<DissnayChararerListResponse>
}
