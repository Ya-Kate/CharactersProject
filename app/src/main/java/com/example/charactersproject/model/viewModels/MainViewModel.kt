package com.example.charactersproject.model.viewModels

import androidx.lifecycle.ViewModel
import com.example.charactersproject.repository.SharedPreferenceRepository

class MainViewModel(
    private val sharedPreference: SharedPreferenceRepository
) : ViewModel() {
    fun firstStart() = sharedPreference.firstStart()
}

