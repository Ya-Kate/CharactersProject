package com.example.charactersproject.ui.adapterMyLikeHero

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.charactersproject.databinding.ItemHeroBinding
import com.example.charactersproject.model.MyDisneyHero

class MyDisneyHeroViewHolder(private val itemCharacherBinding: ItemHeroBinding) :
    RecyclerView.ViewHolder(itemCharacherBinding.root) {
    fun bind(item: MyDisneyHero) {
        itemCharacherBinding.text.text = item.name

        Glide.with(itemCharacherBinding.root.context).load(item.image)
            .into(itemCharacherBinding.image)
    }
}