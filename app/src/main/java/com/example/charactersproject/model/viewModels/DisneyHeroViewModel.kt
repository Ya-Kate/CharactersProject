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
import com.example.charactersproject.model.MyDisneyHero
import com.example.charactersproject.repository.DisneyHeroApiRepository
import com.example.charactersproject.repository.DisneyDataSource
import com.example.charactersproject.utils.toDataHero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DisneyHeroViewModel @Inject constructor(
    private val disneyHeroApiRepository: DisneyHeroApiRepository,
    private val disneyDataSource: DisneyDataSource
) : ViewModel() {

    private val listDisneyHeroes = MutableLiveData<ArrayList<Data>>()
    val listDisneyHero = MutableLiveData<DataHero>()
    val listMyLikeDisneyHero = MutableLiveData<ArrayList<MyDisneyHero>>()
    val image = MutableLiveData<String>()
    val name = MutableLiveData<String>()

    val flowDisneyList = Pager(
        PagingConfig(pageSize = 8)
    ) {
        disneyDataSource
    }.flow
        .cachedIn(viewModelScope)

    fun getMyDisneyHeroList() {
        viewModelScope.launch(Dispatchers.IO) {
            listMyLikeDisneyHero.postValue(disneyHeroApiRepository.getMyListDisneyHero())
        }
    }

    fun addMyDisneyHeroList(name: String, image: String, idHero: String) {
        val heroAdded: (() -> Unit)? = null
        viewModelScope.launch(Dispatchers.IO) {
            disneyHeroApiRepository.addMyDisneyHero(MyDisneyHero(0, name, image, idHero))
            heroAdded?.invoke()
        }
    }

    fun getList() {
        viewModelScope.launch(Dispatchers.IO) {
            val listResponse = disneyHeroApiRepository.getHeroFactApi(1, 8)
            if (listResponse.isSuccessful) {
                listDisneyHeroes.postValue(listResponse.body()?.data)
            }
        }
    }

    fun getImageDisneyHero(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = disneyHeroApiRepository.getImageDisneyHero(id)
            Log.d(
                "MyLog",
                "getImageDisneyHero ${response.body()?.imageUrl.toString()}"
            )
            image.postValue(response.body()?.imageUrl)
            name.postValue(response.body()?.name)
        }
    }

    fun getHero(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = disneyHeroApiRepository.getImageDisneyHero(id)
            if (response.isSuccessful)
                listDisneyHero.postValue(response.body()?.toDataHero())
        }
    }
}

