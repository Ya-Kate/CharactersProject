package com.example.charactersproject.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.charactersproject.Data
import com.example.charactersproject.DataCharacter
import com.example.charactersproject.repository.DisneyCharacherApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DisnayCharacherViewModel @Inject constructor(

    private val disneyCharacherApiRepository: DisneyCharacherApiRepository) : ViewModel() {

    val listDisneyCharacher = MutableLiveData<ArrayList<Data>>()

    fun getList() {
        viewModelScope.launch(Dispatchers.IO) {
            val listResponse = disneyCharacherApiRepository.getChercherFact()
            if (listResponse.isSuccessful) {
                listDisneyCharacher.postValue(listResponse.body()?.data)
            }
        }
    }

}

