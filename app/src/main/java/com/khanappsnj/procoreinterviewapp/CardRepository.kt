package com.khanappsnj.procoreinterviewapp

import android.content.Context

class CardRepository private constructor(context : Context) {


    companion object {
        private var INSTANCE: CardRepository? = null

        fun initialize(context: Context){
            if(INSTANCE == null){
                INSTANCE = CardRepository(context)
            }
        }
    }

    fun get(): CardRepository{
        return INSTANCE ?: throw java.lang.IllegalStateException("Card repository must be initalized")
    }
}