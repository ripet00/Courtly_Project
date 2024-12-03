package com.example.courtlyproject.Feature.detail.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.courtlyproject.Feature.detail.viewmodel.detaillapangan_vm


@Composable
fun detailcontent(

    navController: NavController
) {



}

@Composable
fun top(
    detaillapanganViewModel: detaillapangan_vm = viewModel()
) {


    val getDetail = detaillapanganViewModel.state.value
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        Text(text = getDetail.nama)
        Text(text = getDetail.kategori.toString())
        Text(text = getDetail.alamat)
        Text(text = getDetail.jadwal)
        Text(text = getDetail.harga.toString())

    }
}