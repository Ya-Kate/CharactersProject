package com.example.charactersproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.charactersproject.repository.SharedPreferenceRepositiry
import com.example.charactersproject.ui.AllDisnayCharacherFragment
import com.example.charactersproject.ui.DisnayCharacherViewModel
import com.example.charactersproject.ui.MainViewModel
import com.example.charactersproject.ui.StartDisnayCharacherFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

//    @Inject
//    lateinit var sharedPreferenceRepositiry: SharedPreferenceRepositiry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (viewModel.firstStart()) {
            addFragment(AllDisnayCharacherFragment())
        } else (
                addFragment(StartDisnayCharacherFragment())
                )
    }

    fun addFragment(fragment: Fragment) {
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(com.google.android.material.R.id.container, fragment)
            .commit()
    }
}

