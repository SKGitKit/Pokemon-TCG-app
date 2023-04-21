package com.khanappsnj.procoreinterviewapp

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("cards")
    suspend fun getCards(): Response<Card>
}