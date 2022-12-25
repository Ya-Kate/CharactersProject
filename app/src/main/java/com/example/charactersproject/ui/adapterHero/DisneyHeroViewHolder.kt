package com.example.charactersproject.ui.adapterHero

import androidx.recyclerview.widget.RecyclerView
import com.example.charactersproject.databinding.ItemListFilmsBinding
import com.example.charactersproject.model.HeroShow
import com.example.charactersproject.ui.adapterNameFilms.FilmsAdapter
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent

class DisneyHeroViewHolder(
    private val binding: ItemListFilmsBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: HeroShow) {
        binding.title.text = item.title
        binding.view.run {
            if (adapter == null) {
                adapter = FilmsAdapter()
                layoutManager = FlexboxLayoutManager(binding.root.context).apply {
                    flexDirection = FlexDirection.ROW
                    justifyContent = JustifyContent.FLEX_END
                }
            }
            (adapter as? FilmsAdapter)?.submitList(item.list)
        }
    }
}