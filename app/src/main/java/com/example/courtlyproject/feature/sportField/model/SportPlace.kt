package com.example.courtlyproject.feature.sportField.model

import androidx.compose.ui.graphics.painter.Painter

data class SportPlace(
    val icon : Painter,
    val name: String,
    val distance: Double,
    val rating: Double,
    val price: String
)
