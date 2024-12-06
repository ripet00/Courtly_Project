package com.example.courtlyproject.user.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courtlyproject.R

@Composable
fun PesananScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        HeaderSection()
        TitleSection()
        OrderList()
    }
}

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(
                color = Color(0xFFB4D7B4), // Warna hijau header
                shape = RoundedCornerShape(bottomStart = 60.dp) // Lekukan sudut
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft, // Tombol kembali
                contentDescription = "Back",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Kembali",
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black
            )
        }

    }
}

@Composable
fun TitleSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Pesanan",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "Semua riwayat pesanan yang pernah kamu lakukan ada disini!",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
    }
}

@Composable
fun OrderItem(
    image: Painter,
    title: String,
    subtitle: String,
    date: String,
    status: String,
    statusColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(12.dp), // Padding dalam kontainer
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = image,
            contentDescription = "Lapangan",
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = subtitle, color = Color.Gray, fontSize = 14.sp)
            Text(text = date, color = Color.Gray, fontSize = 12.sp)
        }
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = status,
                color = statusColor,
                fontSize = 12.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            TextButton(onClick = { /* Aksi beri rating */ }) {
                Text(
                    text = "Beri rating",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun OrderList() {
    Column {
        OrderItem(
            image = painterResource(id = R.drawable.stadium),
            title = "Lapangan Teknik",
            subtitle = "Lapangan Basket Kayu",
            date = "Rabu, 19 Jun 2024",
            status = "Belum main",
            statusColor = Color.Red
        )
        OrderItem(
            image = painterResource(id = R.drawable.stadium),
            title = "Lapangan Teknik",
            subtitle = "Lapangan Basket Kayu",
            date = "Rabu, 17 Jan 2024",
            status = "Berhasil",
            statusColor = Color.Blue
        )
        OrderItem(
            image = painterResource(id = R.drawable.stadium),
            title = "Lapangan Teknik",
            subtitle = "Lapangan Basket Kayu",
            date = "Selasa, 23 Apr 2024",
            status = "Sedang berlangsung",
            statusColor = Color.Green
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun pesananPreview(){
    PesananScreen()
}




