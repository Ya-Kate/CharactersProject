package com.example.charactersproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.charactersproject.Data
import com.example.charactersproject.databinding.ItemCharacherBinding

class DisnayAdapter : androidx.recyclerview.widget.ListAdapter<Data, DisneyViewHolder> (DisneyDifUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisneyViewHolder {
        return DisneyViewHolder (
            ItemCharacherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
    }

    override fun onBindViewHolder(holder: DisneyViewHolder, position: Int) {
         holder.bind(getItem(position))
    }

}

