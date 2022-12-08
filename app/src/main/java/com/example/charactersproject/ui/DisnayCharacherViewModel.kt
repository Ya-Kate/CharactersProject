package com.example.charactersproject.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.charactersproject.Data
import com.example.charactersproject.DataCharacter
import com.example.charactersproject.repository.DisneyCharacherApiRepository
import com.example.charactersproject.repository.DisneyDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DisnayCharacherViewModel @Inject constructor(
    private val disneyCharacherApiRepository: DisneyCharacherApiRepository,
    private val disneyDataSource: DisneyDataSource
) : ViewModel() {

    val listDisneyCharacher = MutableLiveData<ArrayList<Data>>()

    val image = MutableLiveData<String>()

    val flowDisneyList = Pager(
        PagingConfig(pageSize = 8)
    ) {
        disneyDataSource
    }.flow
        .cachedIn(viewModelScope)

    fun getList() {
        viewModelScope.launch(Dispatchers.IO) {
            val listResponse = disneyCharacherApiRepository.getChercherFact(1,8)
            if (listResponse.isSuccessful) {
                listDisneyCharacher.postValue(listResponse.body()?.data)
            }
        }
    }

    fun getImageDinneyCharacher(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = disneyCharacherApiRepository.getImageDinneyCharacher(id)
            Log.d(
                "MyLog",
                "getImageDinneyCharacher ${response.body()?.data?.firstOrNull()?.imageUrl.toString()}"
            )
            image.postValue(response.body()?.data?.firstOrNull()?.imageUrl)
        }
    }

}

