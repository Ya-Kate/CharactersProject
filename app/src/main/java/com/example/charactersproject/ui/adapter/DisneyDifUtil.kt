package com.example.charactersproject.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.charactersproject.Data

class DisneyDifUtil : DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem == newItem
    }
}