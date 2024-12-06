package com.example.courtlyproject.model

data class SportPlace(
    val name: String,
    val kategori: List<String> = listOf(""),
    val rating: Double,
    val price: Int,

    val id: String,
)
