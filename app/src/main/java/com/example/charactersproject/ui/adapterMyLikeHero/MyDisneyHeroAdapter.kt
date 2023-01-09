package com.example.charactersproject.ui.adapterMyLikeHero

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.charactersproject.databinding.ItemHeroBinding
import com.example.charactersproject.model.MyDisneyHero

class MyDisneyHeroAdapter :
    PagingDataAdapter<MyDisneyHero, MyDisneyHeroViewHolder>(MyDisneyHeroDifUtil()) {

    private var list = arrayListOf<MyDisneyHero>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDisneyHeroViewHolder {
        return MyDisneyHeroViewHolder(
            ItemHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyDisneyHeroViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun selList(list: ArrayList<MyDisneyHero>) {
        this.list = list
    }
}