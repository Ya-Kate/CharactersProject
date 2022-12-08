package com.example.charactersproject.repository

import androidx.lifecycle.MutableLiveData
import com.example.charactersproject.model.DissnayChararerListResponse
import com.example.charactersproject.network.DisnayCharacherFactApi
import com.example.charactersproject.network.Network
import retrofit2.Response
import javax.inject.Inject

class DisneyCharacherApiRepository @Inject constructor(private val api: DisnayCharacherFactApi) {

    private val network = Network()

    suspend fun getChercherFact(page:Int, limit:Int): Response<DissnayChararerListResponse> {
        return network.getCharacherFactApi().getFact(page, limit)
    }

    suspend fun getImageDinneyCharacher(idImage: String):Response<DissnayChararerListResponse> {
        return network.getCharacherFactApi().getOneCharacher(idImage)
    }

}