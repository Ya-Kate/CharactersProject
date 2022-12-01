package com.example.charactersproject.repository

import com.example.charactersproject.model.DissnayChararerListResponse
import com.example.charactersproject.network.DisnayCharacherFactApi
import com.example.charactersproject.network.Network
import retrofit2.Response
import javax.inject.Inject

class DisneyCharacherApiRepository @Inject constructor(private val api: DisnayCharacherFactApi) {

    suspend fun getChercherFact(): Response<DissnayChararerListResponse> {
        return Network().getCharacherFactApi().getFact()
    }


}