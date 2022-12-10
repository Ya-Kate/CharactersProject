package com.example.charactersproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.GridLayoutManager
import com.example.charactersproject.Data
import com.example.charactersproject.R
import com.example.charactersproject.databinding.FragmentAllHeroesBinding
import com.example.charactersproject.model.viewModels.DisnayHeroViewModel
import com.example.charactersproject.ui.adapter.DisneyAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AllDisneyHeroesFragment : Fragment() {

    private lateinit var binding: FragmentAllHeroesBinding
    private val viewModel: DisnayHeroViewModel by viewModels()

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

//        viewModel.listDisneyCharacher.observe(viewLifecycleOwner) {
//            setList(it)
//        }
//        viewModel.getList()


        binding.bottonMy.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, MyDisneyHerotsFragment())
                .addToBackStack("")
                .commit()
        }

        lifecycleScope.launch {
            viewModel.flowDisneyList.collectLatest { pagingData ->
                setList(pagingData)
            }
        }
        viewModel.getList()
    }

    private suspend fun setList(list: PagingData<Data>) {
        binding.listNote.run {
            if (adapter == null) {
                adapter = DisneyAdapter {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, ChooseDisneyHeroFtagment().apply {
                            arguments = bundleOf("ID" to it.id.toString())
                        })
                        .addToBackStack("")
                        .commit()
                }
                layoutManager = GridLayoutManager(requireContext(), 2)
            }
            (adapter as? DisneyAdapter)?.submitData(list)
        }
    }
}