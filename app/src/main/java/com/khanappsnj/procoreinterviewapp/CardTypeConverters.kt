package com.khanappsnj.procoreinterviewapp

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CardTypeConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromString(value: String?): List<String>? {
        return value?.split(",")
    }

    @TypeConverter
    fun toString(list: List<String>?): String? {
        return list?.joinToString(",")
    }

    @TypeConverter
    fun attackFromJson(json: String): List<Attack> {
        val type = object : TypeToken<List<Attack>>() {}.type
        return gson.fromJson(json,type)
    }

    @TypeConverter
    fun attackToJson(attacks: List<Attack>): String {
        return gson.toJson(attacks)
    }

    @TypeConverter
    fun weaknessFromJson(json: String): List<Weakness> {
        val type = object : TypeToken<List<Weakness>>() {}.type
        return gson.fromJson(json,type)
    }

    @TypeConverter
    fun weaknessToJson(weaknesses: List<Weakness>): String {
        return gson.toJson(weaknesses)
    }
}