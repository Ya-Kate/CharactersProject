package com.example.charactersproject.ui.adapterMyLikeHero

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.charactersproject.databinding.ItemHeroBinding
import com.example.charactersproject.model.MyDisneyHero

class MyDisneyHeroViewHolder(private val itemHeroBinding: ItemHeroBinding) :
    RecyclerView.ViewHolder(itemHeroBinding.root) {
    fun bind(item: MyDisneyHero) {
        itemHeroBinding.text.text = item.name

        Glide.with(itemHeroBinding.root.context).load(item.image)
            .into(itemHeroBinding.image)
    }
}