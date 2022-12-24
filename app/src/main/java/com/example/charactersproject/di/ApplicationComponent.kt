package com.example.charactersproject.di

import com.example.charactersproject.network.Network
import com.example.charactersproject.ui.AllDisneyHeroesFragment
import com.example.charactersproject.ui.ChooseDisneyHeroFragment
import com.example.charactersproject.ui.StartDisneyHeroFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [Network::class, ApplicationModule::class])
interface ApplicationComponent {
    fun inject(fragment: StartDisneyHeroFragment)
    fun inject(fragment: ChooseDisneyHeroFragment)
    fun inject(fragment: AllDisneyHeroesFragment)
}