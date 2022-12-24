package com.example.charactersproject.ui.adapter

import com.example.charactersproject.model.viewModels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val startViewModule = module {

    viewModel {
        MainViewModel(get())
    }
}
