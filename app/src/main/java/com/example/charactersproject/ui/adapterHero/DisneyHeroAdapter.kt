package com.example.charactersproject.ui.adapterHero

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.charactersproject.databinding.ItemListFilmsBinding
import com.example.charactersproject.model.HeroShow

class DisneyHeroAdapter : ListAdapter<HeroShow, DisneyHeroViewHolder>(DisneyHeroDifUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisneyHeroViewHolder {
        return DisneyHeroViewHolder(
            ItemListFilmsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DisneyHeroViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}