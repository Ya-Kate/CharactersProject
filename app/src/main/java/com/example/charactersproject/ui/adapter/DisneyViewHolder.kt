package com.example.charactersproject.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.charactersproject.Data
import com.example.charactersproject.databinding.ItemHeroBinding

class DisneyViewHolder(private val itemCharacherBinding: ItemHeroBinding) :
    RecyclerView.ViewHolder(itemCharacherBinding.root) {

    fun bind(item: Data) {
        itemCharacherBinding.text.text = item.name

        Glide.with(itemCharacherBinding.root.context).load(item.imageUrl)
            .into(itemCharacherBinding.image)
    }
}