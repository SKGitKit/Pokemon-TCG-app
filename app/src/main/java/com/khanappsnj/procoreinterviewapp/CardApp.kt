package com.khanappsnj.procoreinterviewapp

import android.app.Application

class CardApp : Application() {
    override fun onCreate() {
        super.onCreate()
        CardRepository.initialize(this)
    }
}