package com.example.charactersproject.model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.findNavController
import com.example.charactersproject.R
import com.example.charactersproject.model.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (viewModel.firstStart()) {
            findNavController(R.id.my_nav_host_fragment).navigate(R.id.action_startDisneyHeroFragment_to_allDisneyHeroesFragment3)
        }
    }
}

