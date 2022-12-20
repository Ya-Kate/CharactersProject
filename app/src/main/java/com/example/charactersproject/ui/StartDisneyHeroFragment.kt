package com.example.charactersproject.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.charactersproject.App
import com.example.charactersproject.R
import com.example.charactersproject.databinding.FragmentViewStartBinding
import com.example.charactersproject.model.viewModels.MainViewModel
import com.example.charactersproject.model.viewModels.MainViewModelFactory
import com.example.charactersproject.repository.SharedPreferenceRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class StartDisneyHeroFragment : Fragment() {

    private lateinit var binding: FragmentViewStartBinding

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private val viewModel: MainViewModel by viewModels {
        mainViewModelFactory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.firstStart().not()
        binding.getStarted.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, AllDisneyHeroesFragment())
                .addToBackStack("")
                .commit()
        }

    }

}




