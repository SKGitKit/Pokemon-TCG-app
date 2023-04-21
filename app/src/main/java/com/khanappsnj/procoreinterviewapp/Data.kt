package com.khanappsnj.procoreinterviewapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Data(
    val hp: String,
    @PrimaryKey val id: String,
    val images: Images,
    val name: String,
    val subtypes: List<String>,
    val supertype: String,
    val types: List<String>,
    val attacks: List<Attack>,
    val weaknesses : List<Weakness>
)