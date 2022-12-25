package com.example.charactersproject.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.charactersproject.Data
import com.example.charactersproject.databinding.ItemHeroBinding

class DisneyViewHolder(private val itemDisneyHeroBinding: ItemHeroBinding) :
    RecyclerView.ViewHolder(itemDisneyHeroBinding.root) {

    fun bind(item: Data) {
        itemDisneyHeroBinding.text.text = item.name

        Glide.with(itemDisneyHeroBinding.root.context).load(item.imageUrl)
            .into(itemDisneyHeroBinding.image)
    }
}