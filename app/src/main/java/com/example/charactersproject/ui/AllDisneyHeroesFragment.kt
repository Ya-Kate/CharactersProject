package com.example.charactersproject.ui

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.charactersproject.Data
import com.example.charactersproject.R
import com.example.charactersproject.databinding.FragmentAllHeroesBinding
import com.example.charactersproject.model.MyDisneyHero
import com.example.charactersproject.model.viewModels.DisneyHeroViewModel
import com.example.charactersproject.ui.adapter.DisneyAdapter
import com.example.charactersproject.ui.adapterMyLikeHero.MyDisneyHeroAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AllDisneyHeroesFragment : Fragment() {

    private lateinit var binding: FragmentAllHeroesBinding
    private val viewModel: DisneyHeroViewModel by viewModels()
    var isHeroLike: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllHeroesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val animator = ValueAnimator.ofFloat(0F, 1F)
        animator.addUpdateListener {
            binding.textMy.alpha = it.animatedFraction
            binding.textAll.alpha = it.animatedValue as Float
        }
        animator.duration = 4000
        animator.start()

        binding.buttonAll.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, AllDisneyHeroesFragment())
                .commit()
        }

        binding.buttonMy.setOnClickListener {
            binding.buttonMy.setImageDrawable(resources.getDrawable(R.drawable.icon_red_like))
            binding.buttonMy.setBackgroundDrawable(resources.getDrawable(R.drawable.bg_all_my_heroes))
            binding.textMy.setTextColor(resources.getColor(R.color.textTitle))
            binding.textAll.setTextColor(resources.getColor(R.color.bg_button_no_activity))
            binding.buttonAll.setBackgroundDrawable(resources.getDrawable(R.drawable.bg_all_my_heroes_not_activity))

            Log.e("AllDisneyHeroesFragment", "break out")
//            throw RuntimeException("Test Crash")
//            lifecycleScope.launch(Dispatchers.IO) {
            viewModel.listMyLikeDisneyHero.observe(viewLifecycleOwner) { myDisneyHereList ->
                if (myDisneyHereList.size == 0) {
                    Toast.makeText(context, "no like hero", Toast.LENGTH_LONG).show()
                }
                setMyList(myDisneyHereList)
            }
//            }
            viewModel.getMyDisneyHeroList()
        }

        lifecycleScope.launch {
            viewModel.flowDisneyList.collectLatest { pagingData ->
                setList(pagingData)
            }
        }
        viewModel.getList()
    }

    private fun setMyList(list: ArrayList<MyDisneyHero>) {
        binding.listNote.run {
            if (adapter == null) {
                adapter = MyDisneyHeroAdapter()
                layoutManager = LinearLayoutManager(requireContext())
            }
            (adapter as? MyDisneyHeroAdapter)?.selList(list)
        }
    }

    private suspend fun setList(list: PagingData<Data>) {
        binding.listNote.run {
            if (adapter == null) {

                adapter = DisneyAdapter { data ->
                    viewModel.listMyLikeDisneyHero.observe(viewLifecycleOwner) { myList ->
                        for (i in myList.indices) {
                            isHeroLike = myList[i].name == data.name
                        }
                        arguments = bundleOf("BOOL" to isHeroLike)
                    }

                    parentFragmentManager.commit {
                        setCustomAnimations(
                            R.anim.anim_open_fragment,
                            R.anim.anim_close_fragment_allhero
                        )
                        replace(R.id.container, ChooseDisneyHeroFragment().apply {
                            arguments = bundleOf("ID" to data.id.toString())
                        })
                            .addToBackStack("ChooseDisneyHeroFragment")
                    }

                }
                layoutManager = GridLayoutManager(requireContext(), 2)
            }
            (adapter as? DisneyAdapter)?.submitData(list)
        }
    }
}

