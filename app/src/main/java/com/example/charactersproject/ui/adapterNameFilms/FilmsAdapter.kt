package com.example.charactersproject.ui.adapterNameFilms

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.charactersproject.databinding.ItemListFilmsBinding
import com.example.charactersproject.databinding.ItemNameFilmsBinding

class FilmsAdapter : ListAdapter<String, FilmsViewHolder>(FilmsDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        return FilmsViewHolder(
            ItemNameFilmsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false )
        )
    }

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}