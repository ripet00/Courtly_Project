package com.example.courtlyproject.user.presentation.view

import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.courtlyproject.R

@Composable
fun PesananScreen(navController: NavController) {
    var showPopup by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        HeaderSection(navController)
        TitleSection()
        OrderList(navController = navController, onShowPopup = { showPopup = true })
    }

    // Popup Global
    if (showPopup) {
        RatingPopup(
            onDismiss = { showPopup = false },
            onSubmit = { rating, review ->
                showPopup = false
                Log.d("Rating", "Rating: $rating, Review: $review")
            },
            navController = navController
        )
    }
}

@Composable
fun HeaderSection(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(
                color = Color(0xFF79B791), // Warna hijau header
                shape = RoundedCornerShape(bottomStart = 60.dp) // Lekukan sudut
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top=48.dp)
                .clickable {
                    navController.popBackStack()
                },
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
                color = Color.Black,
                fontWeight = FontWeight.Bold
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
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "Riwayat pesanan yang pernah anda lakukan ada disini!",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
    }
}

@Composable
fun OrderList(navController: NavController, onShowPopup: () -> Unit) {
    Column {
        OrderItem(
            image = painterResource(id = R.drawable.stadium),
            title = "Lapangan Teknik",
            subtitle = "Lapangan Basket Kayu",
            date = "Rabu, 19 Jun 2024",
            status = "Belum main",
            statusColor = Color.Red,
            navController = navController,
            onShowPopup = onShowPopup
        )
        OrderItem(
            image = painterResource(id = R.drawable.stadium),
            title = "Lapangan Teknik",
            subtitle = "Lapangan Basket Kayu",
            date = "Rabu, 17 Jan 2024",
            status = "Berhasil",
            statusColor = Color.Blue,
            navController = navController,
            onShowPopup = onShowPopup
        )
        OrderItem(
            image = painterResource(id = R.drawable.stadium),
            title = "Lapangan Teknik",
            subtitle = "Lapangan Basket Kayu",
            date = "Selasa, 23 Apr 2024",
            status = "Sedang berlangsung",
            statusColor = Color.Green,
            navController = navController,
            onShowPopup = onShowPopup
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
    statusColor: Color,
    navController: NavController,
    onShowPopup: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(12.dp),
            )
            .padding(12.dp),
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
        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = status,
                color = statusColor,
                fontSize = 12.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Button(
                onClick = onShowPopup,
                modifier = Modifier,
                colors = ButtonDefaults.buttonColors(Color(0xFF79B791))
            ) {
                Text(text = "Beri Rating", color = Color.White)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RatingPopup(
    onDismiss: () -> Unit,
    onSubmit: (Int, String) -> Unit,
    navController: NavController
) {
    var rating by remember { mutableStateOf(0) }
    var review by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f))
            .clickable(onClick = onDismiss, indication = null, interactionSource = remember { MutableInteractionSource() }),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFF82D4AA))
                .padding(16.dp)
                .fillMaxWidth(0.8f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                // Title
                Text(
                    text = "Gimana mainnya?",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Ceritakan pengalaman olahraga kamu!",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Rating Stars
                Row(horizontalArrangement = Arrangement.Center) {
                    (1..5).forEach { index ->
                        Icon(
                            imageVector = if (index <= rating) Icons.Default.Star else Icons.Outlined.Star,
                            contentDescription = "Rating $index",
                            tint = Color(0xFFFFD700),
                            modifier = Modifier
                                .size(40.dp)
                                .clickable { rating = index }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Input Field
                OutlinedTextField(
                    value = review,
                    onValueChange = { review = it },
                    label = { Text("Bagikan pengalaman kamu selama bermain!", fontSize = 15.sp) },
                    shape = RoundedCornerShape(32.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Submit Button
                Button(
                    onClick = {
                        onSubmit(rating, review)
                        navController.navigate("reviewpage")
                              },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White),
                    colors = ButtonDefaults.buttonColors(
                        Color.White,
                        contentColor = Color(0xFF82D4AA)
                    )
                ) {
                    Text(text = "Kirim", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}





