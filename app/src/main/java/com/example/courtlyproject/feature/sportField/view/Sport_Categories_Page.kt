package com.example.courtlyproject.feature.sportField.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.courtlyproject.R
import com.example.courtlyproject.feature.componen_ui.SportPlaceItem
import com.example.courtlyproject.feature.componen_ui.TopNaviagtion
import com.example.courtlyproject.feature.sportField.model.SportPlace


@Composable
fun SportCategories(navController: NavController){
    val places = listOf(
        SportPlace(
            icon = painterResource(R.drawable.stadium),
            name = "Lapangan Teknik",
            distance = .10,
            rating = 4.7,
            price = "100k/jam"),
        SportPlace(
            icon = painterResource(R.drawable.stadium),
            name = "Lapangan Teknik",
            distance = .10,
            rating = 4.7,
            price = "100k/jam"),
        SportPlace(
            icon = painterResource(R.drawable.stadium),
            name = "Lapangan Teknik",
            distance = .10,
            rating = 4.7,
            price = "100k/jam"),
        SportPlace(
            icon = painterResource(R.drawable.stadium),
            name = "Lapangan Teknik",
            distance = .10,
            rating = 4.7,
            price = "100k/jam"),
        SportPlace(
            icon = painterResource(R.drawable.stadium),
            name = "Lapangan Teknik",
            distance = .10,
            rating = 4.7,
            price = "100k/jam"),
        SportPlace(
            icon = painterResource(R.drawable.stadium),
            name = "Lapangan Teknik",
            distance = .10,
            rating = 4.7,
            price = "100k/jam"),
        SportPlace(
            icon = painterResource(R.drawable.stadium),
            name = "Lapangan Teknik",
            distance = .10,
            rating = 4.7,
            price = "100k/jam"),
        SportPlace(
            icon = painterResource(R.drawable.stadium),
            name = "Lapangan Teknik",
            distance = .10,
            rating = 4.7,
            price = "100k/jam"),
        SportPlace(
            icon = painterResource(R.drawable.stadium),
            name = "Lapangan Teknik",
            distance = .10,
            rating = 4.7,
            price = "100k/jam"),
    )
    Column (
        modifier = Modifier
            .background(color = Color.White)
    ) {
        TopNaviagtion("Basket")
        Spacer(modifier = Modifier.height(20.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // Jumlah kolom
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            content = {
                items(places) { place ->
                    SportPlaceItem(place) // Konten setiap item
                }
            }
        )
    }
}