package com.example.charactersproject.model.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.charactersproject.repository.DisneyDataSource
import com.example.charactersproject.repository.DisneyHeroApiRepository
import javax.inject.Inject

class DisneyHeroViewModelFactory @Inject constructor(
    private val disneyHeroApiRepository: DisneyHeroApiRepository,
    private val disneyDataSource: DisneyDataSource
) :ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return DisneyHeroViewModel (disneyHeroApiRepository, disneyDataSource) as T
    }
}