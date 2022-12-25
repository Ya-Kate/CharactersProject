package com.example.charactersproject.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.charactersproject.R
import com.example.charactersproject.databinding.FragmentChooseHeroesBinding
import com.example.charactersproject.model.HeroShow
import com.example.charactersproject.model.viewModels.DisneyHeroViewModel
import com.example.charactersproject.ui.adapterHero.DisneyHeroAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChooseDisneyHeroFragment : Fragment() {

    private val viewModel: DisneyHeroViewModel by viewModels()
    private lateinit var binding: FragmentChooseHeroesBinding
    private var idImage: String = ""
    var name: String = ""
    var image: String = ""
    var isHeroLike: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooseHeroesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.image.observe(viewLifecycleOwner) {
            image = it
            Glide.with(requireContext()).load(it).into(binding.imageChoose)
            Log.d("MyLog", "Glide $it")
        }

        viewModel.name.observe(viewLifecycleOwner) {
            name = it
            binding.nameHero.text = it
        }

        arguments?.getBoolean("BOOL")?.let {
            isHeroLike = it
        }

        arguments?.getString("ID")?.let { id ->
            Log.d("MyLog", "getString arguments: $id")
            viewModel.getImageDisneyHero(id)
            idImage = id

            if (isHeroLike) {
                binding.buttonAddMyDisney.setImageDrawable(resources.getDrawable(R.drawable.icon_red_like))
            }

            viewModel.listDisneyHero.observe(viewLifecycleOwner) {
                setListDisneyHeroShow(it.listHeroShow)
            }
            viewModel.getHero(id)
        }

        binding.buttonBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.buttonAddMyDisney.setOnClickListener {
            if (!isHeroLike) {
                viewModel.addMyDisneyHeroList(name, image, idImage)
            }
            if (isHeroLike) {
                Toast.makeText(context, "no like hero", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun setListDisneyHeroShow(list: ArrayList<HeroShow>) {
        binding.listFilms.run {
            if (adapter == null) {
                adapter = DisneyHeroAdapter()
                layoutManager = LinearLayoutManager(requireContext())
            }
            (adapter as? DisneyHeroAdapter)?.submitList(list)
        }
    }



}




