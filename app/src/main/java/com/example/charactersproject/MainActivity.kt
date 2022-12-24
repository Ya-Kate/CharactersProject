package com.example.charactersproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import com.example.charactersproject.ui.AllDisneyHeroesFragment
import com.example.charactersproject.model.viewModels.MainViewModel
import com.example.charactersproject.repository.SharedPreferenceRepository
import com.example.charactersproject.ui.StartDisneyHeroFragment
import com.example.charactersproject.ui.adapter.startViewModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(startViewModule)

        if (viewModel.firstStart()) {
            addFragment(AllDisneyHeroesFragment())
        } else {
            addFragment(StartDisneyHeroFragment())
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        loadKoinModules(startViewModule)
    }

    fun addFragment(fragment: Fragment) {
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(com.google.android.material.R.id.container, fragment)
            .commit()
    }
}

