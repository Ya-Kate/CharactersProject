package com.example.charactersproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.charactersproject.R
import com.example.charactersproject.databinding.FragmentMyDisneyHeroesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyDisneyHeroesFragment : Fragment() {
    private lateinit var binding: FragmentMyDisneyHeroesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyDisneyHeroesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonBack.setOnClickListener {
            findNavController().navigate(R.id.action_myDisneyHeroesFragment_to_allDisneyHeroesFragment)
        }
    }
}