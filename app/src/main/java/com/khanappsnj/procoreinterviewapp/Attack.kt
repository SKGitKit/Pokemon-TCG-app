package com.khanappsnj.procoreinterviewapp

data class Attack(
    val name: String,
    val cost: List<String>,
    val convertedEnergyCost: Int,
    val damage: String?,
    val text: String
)