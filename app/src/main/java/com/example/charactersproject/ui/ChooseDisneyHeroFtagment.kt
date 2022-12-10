package com.example.charactersproject.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.charactersproject.R
import com.example.charactersproject.databinding.FragmentChooseHeroesBinding
import com.example.charactersproject.model.HeroShow
import com.example.charactersproject.model.viewModels.DisnayHeroViewModel
import com.example.charactersproject.ui.adapter.DisneyAdapter
import com.example.charactersproject.ui.adapterHero.DisneyHeroAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

private const val ID_IMAGE = "idImage"

@AndroidEntryPoint
class ChooseDisneyHeroFtagment : Fragment() {

    private val viewModel: DisnayHeroViewModel by viewModels()
    lateinit var binding: FragmentChooseHeroesBinding

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
            Glide.with(requireContext()).load(it).into(binding.imageChoose)
            Log.d("MyLog", "Glide $it")
        }

        viewModel.name.observe(viewLifecycleOwner) {
            binding.nameCharacher.text = it
        }

        arguments?.getString("ID")?.let { id ->
            Log.d("MyLog", "getString arguments: $id")
            viewModel.getImageDinneyCharacher(id)

            viewModel.listDisneyHero.observe(viewLifecycleOwner) {
                setListDisneyHeroShow(it.listHeroShow )
            }
            viewModel.getHero(id)
        }


        binding.bottonBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.buttonAddMyDisney.setOnClickListener()
        {
//            binding.buttonAddMyDisney.setImageResource(resources.getValue(R.style.button_all_add_my_disney))

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

    companion object {
        fun getImageDisney(id: String): MyDisneyHerotsFragment {
            return MyDisneyHerotsFragment().apply {
                arguments = bundleOf()
                ID_IMAGE to id
            }
        }
    }

}



