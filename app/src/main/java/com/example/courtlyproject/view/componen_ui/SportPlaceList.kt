package com.example.courtlyproject.view.componen_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.courtlyproject.R
import com.example.courtlyproject.model.SportPlace

@Composable
fun SportPlaceList() {
    val places = listOf(
        SportPlace("Lapangan Teknik", 1.10, 4.7, "100k/jam"),
        SportPlace("Lapangan Somba Opu", 3.52, 4.7, "80k/jam"),
        SportPlace("Lapangan Keren", 2.50, 4.7, "100k/jam"),
        SportPlace("Lapangan Ramtek", 1.32, 4.7, "90k/jam"),
        SportPlace("Lapangan PSM", 1.32, 4.7, "90k/jam"),
        SportPlace("Lapangan Unhas", 1.32, 4.7, "90k/jam"),
        SportPlace("Lapangan Mawang", 1.32, 4.7, "90k/jam")
    )

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

@Composable
fun SportPlaceItem(place: SportPlace) {
    Row (
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center
    ){
        Card(
            modifier = Modifier
                .width(180.dp)
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(22.dp)
        ) {
            Column(modifier = Modifier.padding(0.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.stadium),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.Crop
                )
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding( start = 8.dp, top = 0.dp, bottom = 4.dp)

                ) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = place.name, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "${place.distance} km", style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFFFD700))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "${place.rating}")
                        Spacer(modifier = Modifier.width(32.dp))
                        Text(text = place.price, style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
                    }
                }
            }
        }
    }
}