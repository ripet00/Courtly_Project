package com.example.courtlyproject.Feature.detail.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            .padding(16.dp)
            .background(Color.White)
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable {
                    navController.popBackStack()
                }
        ){
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Kembali", style = MaterialTheme.typography.titleLarge)
        }
        Spacer(modifier = Modifier.height(32.dp))
        Detail(viewModel,navController)
        Spacer(modifier = Modifier.height(16.dp))
        Jadwal(navController = navController)
    }
}
@Composable
fun Detail( detaillapanganViewModel: detaillapangan_vm = viewModel() , navController: NavController) {
    val getDetail = detaillapanganViewModel.state.value
    Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Image(
                painter = painterResource(id = R.drawable.gor),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(200.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp, bottomStart = 0.dp, bottomEnd = 0.dp)),
                contentScale = ContentScale.Crop,
            )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                .background(Color(0xFFD9D9D9))
                .padding(16.dp),

        ) {
            Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Text(
                        text = getDetail.nama,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = getDetail.kategori.toString(),
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
//                Spacer(modifier = Modifier.width(20.dp))
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Icon(
                            Icons.Default.LocationOn,
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = getDetail.alamat,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Icon(
                            Icons.Default.DateRange,
                            contentDescription = null,
                            modifier = Modifier
                                .size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = getDetail.jadwal,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .padding(start = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Rp.${getDetail.harga.toString()}k /jam",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.width(130.dp))
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(32.dp))
                        .background(Color.White)
                        .padding(vertical = 6.dp, horizontal = 16.dp)
                        .clickable {
                            navController.navigate("reviewpage")
                        },
                    verticalAlignment = Alignment.CenterVertically,
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
        }
    }
}

@Composable
fun Jadwal(detaillapanganViewModel: detaillapangan_vm = viewModel(),navController: NavController ) {
    val getDetail = detaillapanganViewModel.state.value
    var selectedTimeSlots by remember { mutableStateOf(listOf("13:00", "14:00")) }
    val pricePerHour = getDetail.harga
    val totalPrice = calculateTotalPriceFromDuration(selectedTimeSlots, pricePerHour)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White, RoundedCornerShape(16.dp))
    ) {
        // Date and Location Section
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Pilih Jadwal",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .height(40.dp)
                    .width(1.dp)
            )
            DropdownItem("19")
            DropdownItem("Jun")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Time Slots Section
        TimeSlots(
            slots = listOf("09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"),
            selectedSlots = selectedTimeSlots,
            onSelect = { selectedTimeSlots = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Summary Section
        Row {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Waktu : ${selectedTimeSlots.first()} - ${selectedTimeSlots.last()}",
                    fontSize = 14.sp,
                    color = Color(0xFF4CAF50)
                )
                Text(
                    text = "Total : ${totalPrice}k",
                    fontSize = 14.sp,
                    color = Color(0xFF4CAF50)
                )
            }
            Spacer(modifier = Modifier.width(100.dp))
            Button(
                onClick = {
                    navController.navigate("PaymentSuccess")
                },
                modifier = Modifier,
                colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50))
            ) {
                Text(text = "Pesan", color = Color.White)
            }
        }
    }
}
fun calculateTotalPriceFromDuration(selectedTimeSlots: List<String>, pricePerHour: Int): Int {
    if (selectedTimeSlots.isEmpty()) return 0

    // Ambil waktu pertama dan terakhir
    val startTime = selectedTimeSlots.first()
    val endTime = selectedTimeSlots.last()

    // Konversi waktu ke format jam
    val startHour = startTime.substringBefore(":").toInt()
    val endHour = endTime.substringBefore(":").toInt()

    // Hitung durasi dalam jam
    val duration = endHour - startHour

    // Total harga
    return duration * pricePerHour
}

@Composable
fun DropdownItem(label: String) {
    Row(
        modifier = Modifier
            .background(Color(0xFFF5F5F5), RoundedCornerShape(8.dp))
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = label, fontSize = 16.sp, color = Color.Black)
        Icon(
            Icons.Default.ArrowDropDown,
            contentDescription = null
        )
    }
}

@Composable
fun TimeSlots(slots: List<String>, selectedSlots: List<String>, onSelect: (List<String>) -> Unit) {
    val slotStates = remember { mutableStateListOf<Boolean>().apply { addAll(slots.map { false }) } }

    slots.forEachIndexed { index, time ->
        slotStates[index] = selectedSlots.contains(time)
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        for (i in slots.indices step 4) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                slots.subList(i, (i + 4).coerceAtMost(slots.size)).forEachIndexed { subIndex, slot ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(40.dp)
                            .background(
                                if (slotStates[i + subIndex]) Color(0xFF4CAF50) else Color(0xFFEEEEEE),
                                RoundedCornerShape(8.dp)
                            )
                            .padding(8.dp)
                            .clickable {
                                slotStates[i + subIndex] = !slotStates[i + subIndex]
                                onSelect(
                                    slots.filterIndexed { j, _ -> slotStates[j] }
                                )
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = slot,
                            color = if (slotStates[i + subIndex]) Color.White else Color.Gray,
                            fontSize = 14.sp
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
