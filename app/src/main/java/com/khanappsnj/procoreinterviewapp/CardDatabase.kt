package com.khanappsnj.procoreinterviewapp

import androidx.room.Database
import androidx.room.TypeConverters


@Database(entities = [Data::class], version = 1)
@TypeConverters(CardTypeConverters::class)
abstract class CardDatabase {

}