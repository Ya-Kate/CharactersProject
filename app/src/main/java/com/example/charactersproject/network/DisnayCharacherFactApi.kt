package com.example.charactersproject.network

import com.example.charactersproject.Data
import com.example.charactersproject.DataCharacter
import com.example.charactersproject.model.DissnayChararerListResponse
import retrofit2.Response
import retrofit2.http.GET

interface DisnayCharacherFactApi {

    @GET("/characters")
    suspend fun getFact(): Response<DissnayChararerListResponse>
}
