package com.example.charactersproject.ui.adapterNameFilms

import androidx.recyclerview.widget.RecyclerView
import com.example.charactersproject.databinding.ItemListFilmsBinding
import com.example.charactersproject.databinding.ItemNameFilmsBinding

class FilmsViewHolder(
    private val binding: ItemNameFilmsBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: String) {
        binding.nameFilms.text = item
    }
}