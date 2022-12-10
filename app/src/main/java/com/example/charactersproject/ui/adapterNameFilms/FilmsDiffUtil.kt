package com.example.charactersproject.ui.adapterNameFilms

import androidx.recyclerview.widget.DiffUtil
import com.example.charactersproject.model.HeroShow

class FilmsDiffUtil : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}