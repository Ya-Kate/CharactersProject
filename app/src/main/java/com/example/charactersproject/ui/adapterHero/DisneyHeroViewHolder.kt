package com.example.charactersproject.ui.adapterHero

import androidx.recyclerview.widget.RecyclerView
import com.example.charactersproject.databinding.ItemListFilmsBinding
import com.example.charactersproject.model.HeroShow

class DisneyHeroViewHolder(
    private val binding: ItemListFilmsBinding
) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item:HeroShow) {
            binding.title.text = item.title
        }

}