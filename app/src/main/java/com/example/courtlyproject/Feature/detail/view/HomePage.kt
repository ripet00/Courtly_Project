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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.courtlyproject.Feature.detail.viewmodel.HomePage_vm
import com.example.courtlyproject.R
import com.example.courtlyproject.feature.auth.presentation.viewModel.AuthViewModel
import com.example.courtlyproject.model.SportPlace
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthState


@Composable
fun HomeScreen(navController: NavController,authViewModel: AuthViewModel) {

    val authState by authViewModel.authState.collectAsState()

    LaunchedEffect(authState) {
        when(authState){
            is com.example.courtlyproject.feature.auth.presentation.viewModel.AuthState.UnAuthenticated -> navController.navigate("login")
            else -> Unit

        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
    ) {
        TopBar(navController,authViewModel)
        SearchBar()
        SportSelection()
        SportPlaceList(navController)
    }
}

@Composable
fun TopBar(navController: NavController,authViewModel: AuthViewModel) {
    Box(
        modifier = Modifier
            .padding(vertical = 16.dp, horizontal = 8.dp)
            .height(120.dp)
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
    ){
        Row (
            modifier = Modifier
                .padding(top = 24.dp)
        ) {
            Column {
                Row {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = null,
                        tint = Color.Black
                    )
                    Text(text = "Sulawesi Selatan, Gowa",
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(top = 5.dp)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Column {
                    Text(text = "Temukan", fontSize = 22.sp,fontWeight = FontWeight.Medium)
                    Row {
                        Text(text = "Tempat Olahraga",fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(text = "Disekitarmu!", fontSize = 22.sp,fontWeight = FontWeight.Medium)
                    }
                }
            }
            ProfileMenu(navController, authViewModel)
        }
    }
}
@Composable
fun ProfileMenu(navController: NavController,authViewModel: AuthViewModel) {
    var expanded by remember { mutableStateOf(false) }
    val authState = authViewModel.authState.collectAsState()

    Box {
        IconButton(onClick = { expanded = !expanded }) {
            Image(
                painter = painterResource(R.drawable.nand), // Ganti dengan resource foto profil Anda
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
        }
        // Dropdown Menu
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(Color(0xFF6FCF97)) // Warna latar menu
                .clip(RoundedCornerShape(16.dp))

        ) {
            DropdownMenuItem(
                text = { Text("Profil", color = Color.White) },

                onClick = {
                    expanded = false
                    // Aksi untuk "Profil"
                }
            )
            HorizontalDivider(color = Color.White)
            DropdownMenuItem(
                text = { Text("Pesanan", color = Color.White) },
                onClick = {
                    expanded = false
                    // Aksi untuk "Pesanan"
                }
            )
            HorizontalDivider(color = Color.White)
            DropdownMenuItem(
                text = { Text("Keluar", color = Color.White) },
                onClick = {
                    authViewModel.signout()
                }
            )
        }
    }
}

@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = {text = it},
        placeholder = { Text(
            text = "Cari olahraga favoritmu",
            style = TextStyle(
                color = Color.Gray,
                fontSize = 14.sp
            )
        ) },
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = null)
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.LightGray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xFFD9D9D9))
    )
}

@Composable
fun SportSelection() {
    // List olahraga
    val sports = listOf("Semua","Futsal", "Bulutangkis", "Basket", "tenis","minisoccer","Volly")
    // State untuk olahraga yang dipilih
    var selectedSport by remember { mutableStateOf(sports[0]) }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(sports.size) { index ->
            SportButton(
                text = sports[index],
                isSelected = selectedSport == sports[index],
                onClick = { selectedSport = sports[index] }
            )
        }
    }
}

@Composable
fun SportButton(text: String, isSelected: Boolean, onClick: () -> Unit) {
    // Warna tombol jika dipilih atau tidak
    val backgroundColor = if (isSelected) Color(0xFF81C784) else Color(0xFFE0E0E0) // Warna hijau dan abu-abu
    val textColor = if (isSelected) Color.White else Color.Gray

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(backgroundColor)
            .clickable { onClick() }
            .padding(horizontal = 24.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun SportPlaceList(navController: NavController) {
//    val listLapangan = viewmodel.stateLapangan
    val viewModel: HomePage_vm = viewModel()

    val places = mutableListOf<SportPlace>()
    viewModel.stateLapangan.forEachIndexed { index, detaillapangan ->
        places.add(
            SportPlace(
                name = detaillapangan.nama,
                kategori = detaillapangan.kategori,
                rating = detaillapangan.rating.toDouble(),
                price = detaillapangan.harga,
                id = detaillapangan.id

            )
        )
    }

//    LazyColumn(contentPadding = PaddingValues(16.dp)) {
//        items(places) { place ->
//            SportPlaceItem(place)
//        }
//    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Jumlah kolom
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        content = {
            items(places) { place -> // Mengisi grid dengan 100 item
                SportPlaceItem(place = place, navController = navController, lapanganId = place.id) // Konten setiap item
            }
        }
    )
}

@Composable
fun SportPlaceItem(place: SportPlace, navController: NavController, lapanganId: String) {

    Row (
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center
    ){
        Card(
            modifier = Modifier
                .width(180.dp)
                .padding(8.dp)
                .clickable {
                    navController.navigate("detail/$lapanganId")
                },
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
                    Text(text = "${place.kategori}", style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFFFD700))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "${place.rating}")
                        Spacer(modifier = Modifier.width(15.dp))

                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Rp.${place.price.toString()}", style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
                    }
                }
            }
        }
    }
}