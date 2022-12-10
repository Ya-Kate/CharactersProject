package com.example.charactersproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.charactersproject.R
import com.example.charactersproject.databinding.FragmentViewStartBinding
import com.example.charactersproject.repository.SharedPreferenceRepositiry
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class StartDisnayHeroFragment : Fragment() {

    private lateinit var binding: FragmentViewStartBinding

    @Inject
    lateinit var sharedPreferenceRepositiry: SharedPreferenceRepositiry

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
        sharedPreferenceRepositiry.notFirstStart()
        binding.getStarted.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, AllDisneyHeroesFragment())
                .addToBackStack("")
                .commit()
        }

    }

}




