package com.example.courtlyproject.Feature.detail.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.courtlyproject.Feature.detail.viewmodel.detaillapangan_vm
import com.example.courtlyproject.R


@Composable
fun detailcontent(
    navController: NavController,
    lapanganId: String

) {
    val viewModel: detaillapangan_vm = viewModel()
    LaunchedEffect(key1 = Unit) {
        viewModel.getDetail(lapanganId)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
            .background(Color.White)
    ) {
        top(viewModel)
        Contain()
    }

}

@Composable
fun top(
    detaillapanganViewModel: detaillapangan_vm = viewModel()
) {
    val getDetail = detaillapanganViewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(0.dp),
    ) {

        Column(
            modifier = Modifier,
//                .width(100.dp)
//                .height(100.dp)
//                .padding(20.dp)
//                .background(Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center


        ) {
            Image(
                painter = painterResource(id = R.drawable.stadium),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth() // Mengisi lebar layar
                    .size(300.dp) // Menentukan tinggi gambar
                    .padding(top = 0.dp) // Pastikan tidak ada padding top yang menghalangi
                , // Padding di bawah gambar
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                    .background(Color(0xFFD9D9D9))

            ) {
                Column(

                ) {
                    Row {
                        Column(
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier
                                .padding(8.dp)
                        ) {
                            Text(
                                text = getDetail.nama,
                                style = MaterialTheme.typography.headlineMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                ),
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            Text(
                                text = getDetail.kategori.toString(),
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontWeight = FontWeight.Normal,
                                    color = Color.Gray
                                ),
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .padding(8.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Display the address
                                Text(
                                    text = getDetail.alamat,
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = Color.Black
                                    ),
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Display the schedule
                                Text(
                                    text = getDetail.jadwal,
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = Color.Black
                                    ),
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )
                            }
                        }

                    }


                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(0.4f),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(32.dp))
                                    .background(Color.White)
                                    .padding(8.dp),
                                horizontalArrangement = Arrangement.Center,

                                ) {
                                Icon(
                                    Icons.Default.Star,
                                    contentDescription = null,
                                    tint = Color(0xFFFFD700)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(text = "${getDetail.rating}")
                            }
                        }
                        Column(
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(0.6f),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            // Display the pr
                            Text(
                                text = "Rp.${getDetail.harga.toString()} /jam",
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                ),
                                modifier = Modifier.padding(bottom = 16.dp)
                            )
                        }
                    }
                }

            }
        }

    }
}

@Composable
fun  Contain(

) {
    Box(
        modifier = Modifier

            .background(Color(0xFFD9D9D9)) // Warna latar belakang abu-abu
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Bagian atas (gambar dan teks besar)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center, // Mengatur posisi gambar dan teks secara horizontal
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.stadium),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Gray)
                        .padding(8.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(8.dp))

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Stadium XYZ", // Nama lapangan
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                    Text(
                        text = "Location: City Center", // Alamat lapangan
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Color.Gray
                        ),
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Bagian kedua (rating dan harga)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White)
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFFFD700)) // Icon bintang
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "4.5", // Rating lapangan
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black)
                    )
                }

                Spacer(modifier = Modifier.weight(1f)) // Memberikan jarak di tengah

                Text(
                    text = "Rp. 100,000/jam", // Harga lapangan
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }
}