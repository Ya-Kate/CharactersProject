package com.example.charactersproject.model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.charactersproject.R
import com.example.charactersproject.ui.AllDisneyHeroesFragment
import com.example.charactersproject.model.viewModels.MainViewModel
import com.example.charactersproject.ui.StartDisneyHeroFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (viewModel.firstStart()) {
            addFragment(AllDisneyHeroesFragment())
        } else {
            addFragment(StartDisneyHeroFragment())
        }
    }

    private fun addFragment(fragment: Fragment) {
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(com.google.android.material.R.id.container, fragment)
            .commit()
    }
}

