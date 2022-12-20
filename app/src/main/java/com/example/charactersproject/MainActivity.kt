package com.example.charactersproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.charactersproject.ui.AllDisneyHeroesFragment
import com.example.charactersproject.model.viewModels.MainViewModel
import com.example.charactersproject.ui.StartDisneyHeroFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

//    @Inject
//    lateinit var sharedPreferenceRepositiry: SharedPreferenceRepositiry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (viewModel.firstStart()) {
            addFragment(AllDisneyHeroesFragment())
        } else {
            addFragment(StartDisneyHeroFragment())
        }
    }

    fun addFragment(fragment: Fragment) {
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(com.google.android.material.R.id.container, fragment)
            .commit()
    }
}

