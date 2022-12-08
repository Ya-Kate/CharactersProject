package com.example.charactersproject.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.charactersproject.R
import com.example.charactersproject.databinding.FragmentChooseCharacherBinding
import dagger.hilt.android.AndroidEntryPoint

private const val ID_IMAGE = "idImage"

@AndroidEntryPoint
class ChooseDisneyCharacherFtagment : Fragment() {

    private val viewModel: DisnayCharacherViewModel by viewModels()
    lateinit var binding: FragmentChooseCharacherBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooseCharacherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewModel.image.observe(viewLifecycleOwner) {
            Glide.with(requireContext()).load(it).into(binding.imageChoose)
            Log.d("MyLog","Glide $it")
        }

        arguments?.getString("ID")?.let { id ->
            Log.d("MyLog", "getString arguments: $id")

            viewModel.getImageDinneyCharacher(id)

        }


        binding.bottonBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.buttonAddMyDisney.setOnClickListener()
        {
//            binding.buttonAddMyDisney.setImageResource(resources.getValue(R.style.button_all_add_my_disney))

        }
    }


        companion object {
            fun getImageDisney(id: String): MyDisneyCharacherFragment {
                return MyDisneyCharacherFragment().apply {
                    arguments = bundleOf()
                    ID_IMAGE to id
                }
            }
        }

}



