package com.khanappsnj.procoreinterviewapp

import androidx.room.Dao
import retrofit2.http.Query
import java.util.Date

@Dao
interface CardDao {

    @Query("SELECT * FROM card")
    fun getCards() : List<Date>
}