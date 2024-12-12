package com.example.courtlyproject.Feature.transaction.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DetailPesananPopup(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFF79B791))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Detail Pesanan",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Mohon konfirmasi pembayaran anda.",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Atas nama: Nabil Yamin",
                    color = Color.White,
                    fontSize = 14.sp
                )
                Text(
                    text = "Tanggal/Waktu: 19 Juni 2024, 13:00 - 15:00",
                    color = Color.White,
                    fontSize = 14.sp
                )
                Text(
                    text = "Tempat: Lapangan Teknik",
                    color = Color.White,
                    fontSize = 14.sp
                )
                Text(
                    text = "Jenis: Lapangan Basket Kayu",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Divider(color = Color.White, thickness = 1.dp)

            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Lapangan Basket Kayu x 2j: Rp300.000",
                    color = Color.White,
                    fontSize = 14.sp
                )
                Text(
                    text = "Biaya aplikasi: Rp5.000",
                    color = Color.White,
                    fontSize = 14.sp
                )
                Text(
                    text = "Pajak (5%): Rp15.000",
                    color = Color.White,
                    fontSize = 14.sp
                )
                Text(
                    text = "Total: Rp320.000",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(Color.Gray)
                ) {
                    Text("Batal", color = Color.White)
                }

                Button(
                    onClick = { navController.navigate("PaymentSuccess") },
                    colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                    Text("Bayar", color = Color(0xFF79B791))
                }
            }
        }
    }
}
