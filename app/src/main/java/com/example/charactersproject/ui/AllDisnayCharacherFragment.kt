package com.example.charactersproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.charactersproject.repository.DisneyCharacherApiRepository
import com.example.charactersproject.Data
import com.example.charactersproject.DataCharacter
import com.example.charactersproject.R
import com.example.charactersproject.databinding.FragmentAllCharacherBinding
import com.example.charactersproject.ui.adapter.DisnayAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import retrofit2.Response

@AndroidEntryPoint
class AllDisnayCharacherFragment : Fragment() {

    private lateinit var binding: FragmentAllCharacherBinding

    private val viewModel: DisnayCharacherViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllCharacherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listDisneyCharacher.observe(viewLifecycleOwner) {
            setList(it)
        }
        viewModel.getList()

        binding.bottonMy.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, MyDisneyCharacherFragment())
                .addToBackStack("")
                .commit()
        }
    }

    private fun setList(list:ArrayList<Data>) {
        binding.listNote.run {
            if(adapter == null) {
                adapter = DisnayAdapter()
                layoutManager = GridLayoutManager(requireContext(), 2)
//                layoutManager = LinearLayoutManager(requireContext())
            }
            (adapter as? DisnayAdapter)?.submitList(list)
        }
    }


}