package com.example.charactersproject.ui.adapterHero

import androidx.recyclerview.widget.DiffUtil
import com.example.charactersproject.model.HeroShow

class DisneyHeroDifUtil : DiffUtil.ItemCallback<HeroShow>() {
    override fun areItemsTheSame(oldItem: HeroShow, newItem: HeroShow): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: HeroShow, newItem: HeroShow): Boolean {
        return oldItem == newItem
    }
}