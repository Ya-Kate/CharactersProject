package com.example.charactersproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.charactersproject.Data
import com.example.charactersproject.databinding.ItemHeroBinding

class DisneyAdapter(private val onClick: (image: Data) -> Unit) :
    PagingDataAdapter<Data, DisneyViewHolder>(DisneyDifUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisneyViewHolder {
        return DisneyViewHolder(
            ItemHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: DisneyViewHolder, position: Int) {
        getItem(position)?.let { data ->
            holder.bind(data)
            holder.itemView.setOnClickListener {
                onClick(data)
            }
//         holder.bind(getItem(position))
//        holder.itemView.setOnClickListener {
//            onClick(getItem(position))

        }
    }
}

