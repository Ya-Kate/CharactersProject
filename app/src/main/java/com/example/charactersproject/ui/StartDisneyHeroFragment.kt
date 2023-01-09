package com.example.charactersproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.charactersproject.R
import com.example.charactersproject.databinding.FragmentViewStartBinding
import com.example.charactersproject.repository.SharedPreferenceRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class StartDisneyHeroFragment : Fragment() {

    private lateinit var binding: FragmentViewStartBinding

    @Inject
    lateinit var sharedPreferenceRepository: SharedPreferenceRepository

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
        binding.getStarted.setOnClickListener {
            sharedPreferenceRepository.notFirstStart()
            findNavController().navigate(R.id.action_startDisneyHeroFragment_to_allDisneyHeroesFragment3)
        }
    }
}




