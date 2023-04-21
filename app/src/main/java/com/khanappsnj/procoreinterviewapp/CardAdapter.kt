package com.khanappsnj.procoreinterviewapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khanappsnj.procoreinterviewapp.databinding.CardItemBinding
import com.khanappsnj.procoreinterviewapp.Constants.NAME
import com.khanappsnj.procoreinterviewapp.Constants.TYPE
import com.khanappsnj.procoreinterviewapp.Constants.HP

class CardAdapter(var cards : List<Data>, val onRowClick : (Data) -> Unit) : RecyclerView.Adapter<CardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CardHolder(CardItemBinding.inflate(inflater,parent,false))
    }

    override fun getItemCount(): Int = cards.size ?: 0


    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.bind(cards[position], onRowClick)
    }

    fun sortData (option : String){
        when(option) {
            NAME -> cards = cards.sortedBy { it.name }
            TYPE -> cards = cards.sortedBy { it.types.first() }
            HP -> cards = cards.sortedBy { it.hp }
        }
        notifyDataSetChanged()
    }
}