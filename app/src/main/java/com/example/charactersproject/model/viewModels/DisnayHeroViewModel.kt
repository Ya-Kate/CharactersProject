package com.example.charactersproject.model.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.charactersproject.Data
import com.example.charactersproject.model.DataHero
import com.example.charactersproject.repository.DisneyHeroApiRepository
import com.example.charactersproject.repository.DisneyDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DisnayHeroViewModel @Inject constructor(
    private val disneyCharacherApiRepository: DisneyHeroApiRepository,
    private val disneyDataSource: DisneyDataSource
) : ViewModel() {

    val listDisneyCharacters = MutableLiveData<ArrayList<Data>>()
    val listDisneyHero = MutableLiveData<DataHero>()
    val image = MutableLiveData<String>()
    val name = MutableLiveData<String>()

    val flowDisneyList = Pager(
        PagingConfig(pageSize = 8)
    ) {
        disneyDataSource
    }.flow
        .cachedIn(viewModelScope)

    fun getList() {
        viewModelScope.launch(Dispatchers.IO) {
            val listResponse = disneyCharacherApiRepository.getHeroFactApi(1, 8)
            if (listResponse.isSuccessful) {
                listDisneyCharacters.postValue(listResponse.body()?.data)
            }
        }
    }

    fun getImageDinneyCharacher(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = disneyCharacherApiRepository.getImageDinneyHero(id)
            Log.d(
                "MyLog",
                "getImageDisneyHero ${response.body()?.imageUrl.toString()}"
            )
            image.postValue(response.body()?.imageUrl)
            name.postValue(response.body()?.name)
        }
    }

//    fun getHero(id:String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            val response = disneyCharacherApiRepository.getImageDinneyHero(id)
//            if (response.isSuccessful)
//                listDisneyHero.postValue(response.body()?.toDataHero())
//        }
//    }

}

