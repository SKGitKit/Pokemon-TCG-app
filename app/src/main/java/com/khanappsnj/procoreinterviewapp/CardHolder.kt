package com.khanappsnj.procoreinterviewapp

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.khanappsnj.procoreinterviewapp.databinding.CardItemBinding

class CardHolder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        card: Data,
        onRowClick: (Data) -> Unit
    ) {
        Glide.with(binding.root).load(card.images.small).into(binding.cardImageSmall)
        binding.root.setOnClickListener { onRowClick(card) }
    }
}