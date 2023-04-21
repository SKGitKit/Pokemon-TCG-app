package com.khanappsnj.procoreinterviewapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private const val BASE_URL = "https://api.pokemontcg.io/v2/"

        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun createInstance(): ApiService {
            return retrofit.create(ApiService::class.java)
        }
    }
}