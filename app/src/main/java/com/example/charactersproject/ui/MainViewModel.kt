package com.example.charactersproject.ui

import androidx.lifecycle.ViewModel
import com.example.charactersproject.repository.SharedPreferenceRepositiry
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (
    private val sharedPreference: SharedPreferenceRepositiry
) : ViewModel() {

    fun firstStart() = sharedPreference.firstStart()
}

