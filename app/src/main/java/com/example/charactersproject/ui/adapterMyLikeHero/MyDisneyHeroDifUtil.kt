package com.example.charactersproject.ui.adapterMyLikeHero

import androidx.recyclerview.widget.DiffUtil
import com.example.charactersproject.model.MyDisneyHero

class MyDisneyHeroDifUtil : DiffUtil.ItemCallback<MyDisneyHero>() {
    override fun areItemsTheSame(oldItem: MyDisneyHero, newItem: MyDisneyHero): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MyDisneyHero, newItem: MyDisneyHero): Boolean {
        return oldItem.idHero == newItem.idHero
    }
}