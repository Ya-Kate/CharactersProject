package com.example.charactersproject.model.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.charactersproject.repository.SharedPreferenceRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val sharedPreference: SharedPreferenceRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return MainViewModel(sharedPreference) as T
    }
}