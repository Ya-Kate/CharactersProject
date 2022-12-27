package com.example.charactersproject.ui

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
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
import androidx.fragment.app.commit

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

        val anim = AnimationUtils.loadAnimation(requireContext(), R.anim.anim_button_like)
        binding.buttonAddMyDisney.startAnimation(anim)

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
                ObjectAnimator.ofFloat(binding.buttonAddMyDisney, View.ALPHA, 0F, 1F).apply {
                    duration = 4000
                }.start()
            }

            viewModel.listDisneyHero.observe(viewLifecycleOwner) {
                setListDisneyHeroShow(it.listHeroShow)
            }
            viewModel.getHero(id)
        }

        binding.buttonBack.setOnClickListener {
            parentFragmentManager.commit {
                setCustomAnimations(
                    R.anim.anim_open_fragment,
                    R.anim.anim_close_fragment_heroes
                )
                replace(R.id.container, AllDisneyHeroesFragment())
                    .addToBackStack("AllDisneyHeroesFragment")
            }
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





