package com.example.charactersproject.model.viewModels

import androidx.lifecycle.ViewModel
import com.example.charactersproject.repository.SharedPreferenceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (
    private val sharedPreference: SharedPreferenceRepository
) : ViewModel() {

    fun firstStart() = sharedPreference.firstStart()
}

