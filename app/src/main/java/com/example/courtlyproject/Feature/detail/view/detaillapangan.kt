package com.example.courtlyproject.Feature.detail.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

        Column (
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
                    .size(350.dp) // Menentukan tinggi gambar
                    .padding(top = 0.dp) // Pastikan tidak ada padding top yang menghalangi
                    .padding(bottom = 4.dp), // Padding di bawah gambar
                contentScale = ContentScale.Crop
            )
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

            // Display the address
            Text(
                text = getDetail.alamat,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Black
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Display the schedule
            Text(
                text = getDetail.jadwal,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Black
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Display the price
            Text(
                text = "Harga: ${getDetail.harga.toString()}",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )

        }
    }

//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//            .padding(0.dp),
//
//    )
//    {
//        Image(
//            painter = painterResource(id = R.drawable.stadium),
//            contentDescription = null,
//            modifier = Modifier
//                .fillMaxWidth() // Mengisi lebar layar
//                .height(500.dp) // Menentukan tinggi gambar
//                .padding(top = 0.dp) // Pastikan tidak ada padding top yang menghalangi
//                .padding(bottom = 4.dp) // Padding di bawah gambar
//        )
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.White)
//                .padding(0.dp), // Padding untuk seluruh Box
//            contentAlignment = Alignment.TopCenter // Menempatkan gambar di bagian atas tengah
//        ) {
//            Text(
//                text = getDetail.nama,
//                style = MaterialTheme.typography.headlineMedium.copy(
//                    fontWeight = FontWeight.Bold,
//                    color = Color.Black
//                ),
//                modifier = Modifier.padding(bottom = 8.dp)
//            )
//
//            Text(
//                text = getDetail.kategori.toString(),
//                style = MaterialTheme.typography.bodyLarge.copy(
//                    fontWeight = FontWeight.Normal,
//                    color = Color.Gray
//                ),
//                modifier = Modifier.padding(bottom = 8.dp)
//            )
//
//            // Display the address
//            Text(
//                text = getDetail.alamat,
//                style = MaterialTheme.typography.bodyMedium.copy(
//                    color = Color.Black
//                ),
//                modifier = Modifier.padding(bottom = 8.dp)
//            )
//
//            // Display the schedule
//            Text(
//                text = getDetail.jadwal,
//                style = MaterialTheme.typography.bodyMedium.copy(
//                    color = Color.Black
//                ),
//                modifier = Modifier.padding(bottom = 8.dp)
//            )
//
//            // Display the price
//            Text(
//                text = "Harga: ${getDetail.harga.toString()}",
//                style = MaterialTheme.typography.bodyLarge.copy(
//                    fontWeight = FontWeight.Bold,
//                    color = Color.Black
//                ),
//                modifier = Modifier.padding(bottom = 16.dp)
//            )
//        }




//        Text(text = getDetail.nama)
//        Text(text = getDetail.kategori.toString())
//        Text(text = getDetail.alamat)
//        Text(text = getDetail.jadwal)
//        Text(text = getDetail.harga.toString())

//    }
}