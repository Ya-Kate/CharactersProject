package com.example.charactersproject.ui.adapter

import com.example.charactersproject.model.viewModels.DisneyHeroViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val listHeroModule = module {
    viewModel {
        DisneyHeroViewModel(
            disneyHeroApiRepository = get(),
            disneyDataSource = get()
        )
    }
}