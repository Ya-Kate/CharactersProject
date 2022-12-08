package com.example.charactersproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.charactersproject.R
import com.example.charactersproject.databinding.FragmentMyDisneyCharacherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyDisneyCharacherFragment : Fragment() {
    private lateinit var binding: FragmentMyDisneyCharacherBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyDisneyCharacherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bottonBack.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, AllDisnayCharacherFragment())
                .addToBackStack("")
                .commit()
        }

    }
}