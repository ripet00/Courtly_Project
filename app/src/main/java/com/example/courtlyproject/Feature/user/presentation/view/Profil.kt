package com.example.courtlyproject.user.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.courtlyproject.Feature.auth.presentation.viewModel.AuthViewModel
import com.example.courtlyproject.Feature.user.presentation.viewModel.UserProfileViewModel
import com.example.courtlyproject.R
import com.google.firebase.auth.FirebaseAuth

@Composable
fun UserProfileScreen(navController: NavController, authViewModel: AuthViewModel, viewModel: UserProfileViewModel, userId: String) {
    val userState by viewModel.userState.collectAsState()
    val authState by authViewModel.authState.collectAsState()
    val userId = FirebaseAuth.getInstance().currentUser?.uid

    LaunchedEffect(userId,authState) {
        userId?.let {
            viewModel.fetchUser(it)
        }
        when(authState){
            is com.example.courtlyproject.Feature.auth.presentation.viewModel.AuthState.UnAuthenticated -> navController.navigate("login")
            else -> Unit

        }
    }
    when{
        userState == null -> {
            CircularProgressIndicator(modifier = Modifier.size(160.dp))
        }
        else -> {
            userState?.let { user ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Spacer(modifier = Modifier.height(32.dp))
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    ){
                        Icon(
                            Icons.Default.KeyboardArrowLeft, // Ganti dengan ikon panah
                            contentDescription = "Back"
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Kembali")
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    // Profile Section
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Profile Image
                        Surface(
                            shape = CircleShape,
                            modifier = Modifier.size(80.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.profile), // Ganti dengan foto profil
                                contentDescription = "Profile Picture",
                                contentScale = ContentScale.Crop
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))

                        // Name and Active Info
                        Column {
                            Text(
                                text = user.username,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Aktif sejak - Apr, 2024",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    // Personal Information Section
                    Text(
                        text = "Informasi Pribadi",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Column (modifier = Modifier
                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(8.dp))
                        .padding(4.dp)
                    ) {
                        PersonalInfoItem(Icons.Default.Email, label = "Email", value = user.email)
                        Divider(
                            color = Color.White,
                            thickness = 1.dp,
                            modifier = Modifier.width(400.dp)
                        )
                        PersonalInfoItem(Icons.Default.Phone, label = "Nomor telepon", value = user.nomorHp)
                        Divider(
                            color = Color.White,
                            thickness = 1.dp,
                            modifier = Modifier.width(400.dp)
                        )
                        PersonalInfoItem(Icons.Default.LocationOn, label = "Lokasi", value = "Sulawesi Selatan, Gowa")
                        Divider(
                            color = Color.White,
                            thickness = 1.dp,
                            modifier = Modifier.width(400.dp)
                        )
                        PersonalInfoItem(Icons.Default.DateRange, label = "Tanggal lahir", value = "22 Nov, 2003")
                    }
                    Spacer(modifier = Modifier.height(24.dp))

                    Column (modifier = Modifier
                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(8.dp))
                        .padding(4.dp)) {
                        // Logout and Delete Account Buttons
                        ActionButton(Icons.Default.ExitToApp, label = "Keluar", color = Color.Black, action = {authViewModel.signout()} )
                        Divider(
                            color = Color.White,
                            thickness = 1.dp,
                            modifier = Modifier.width(400.dp)
                        )
                        ActionButton(Icons.Default.Delete, label = "Hapus akun", color = Color.Red, action = {})
                    }
                }
            }
        }
    }
}

@Composable
fun PersonalInfoItem(icon: ImageVector, label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.DarkGray,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = label, fontSize = 14.sp, color = Color.DarkGray)
            Text(text = value, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun ActionButton(icon: ImageVector, label: String, color: Color,action: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable {
                action()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = color,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = label,
            fontSize = 16.sp,
            color = color,
            fontWeight = FontWeight.Bold
        )
    }
}



//@Preview(showBackground = true,
//    showSystemUi = true)
//@Composable
//private fun ProfilPreview(){
//    UserProfileScreen()
//}