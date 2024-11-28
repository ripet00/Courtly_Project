package com.example.courtlyproject.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.courtlyproject.AuthViewModel
import com.example.courtlyproject.R

@Composable
fun SignupPage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {
    var email by remember {
        mutableStateOf("")
    }
    var username by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var repeat_password by rememberSaveable {
        mutableStateOf("")
    }
    var no_hp by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
            // Mengisi ukuran layar penuh
//            .height(LocalConfiguration.current.screenHeightDp.dp / 5)
//            .clip(
//                RoundedCornerShape(
//                    bottomStart = 80.dp,
//                    bottomEnd = 0.dp,
//                    topStart = 0.dp,
//                    topEnd = 0.dp
//                )
//            )
//            .background(Color(0xff79b791))
    ) {
        Image(
            painter = painterResource(id = R.drawable.group_82__1_),
            contentDescription = "logo",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Pendaftaran", fontSize = 32.sp)
            Text(text = "Mohon isi data berikut dengan benar", fontSize = 16.sp)

            Spacer(modifier = Modifier.height(16.dp))

            var isNotEmpty by remember {mutableStateOf(false)}
            OutlinedTextField(
                value = email,
                onValueChange = { email = it
                    isNotEmpty = email.isNotEmpty()
                },
                label = { Text("Masukkan Email", fontSize = 15.sp) },
//            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(8.dp)),
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                //backgroundColor = if (isNotEmpty) Color.White else Color.Gray,
//                //textColor = if (isNotEmpty) Color.Black else Color.DarkGray,
//                focusedBorderColor = Color.Green,
//                unfocusedBorderColor = Color.Gray,
//            ),
                shape = RoundedCornerShape(32.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))

            OutlinedTextField(
                value = username,
                onValueChange = { username = it},
                label = { Text("Nama Pengguna", fontSize = 15.sp) },

                shape = RoundedCornerShape(32.dp)

            )
            Spacer(modifier = Modifier.height(6.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it},
                label = { Text("Kata Sandi", fontSize = 15.sp) },

                shape = RoundedCornerShape(32.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))

            OutlinedTextField(
                value = repeat_password,
                onValueChange = { repeat_password = it},
                label = { Text("Masukkan ulang kata sandi", fontSize = 15.sp) },

                shape = RoundedCornerShape(32.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))

            OutlinedTextField(
                value = no_hp,
                onValueChange = { no_hp = it},
                label = { Text("No Handphone", fontSize = 15.sp) },

                shape = RoundedCornerShape(32.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {navController.navigate("login")},
                modifier = Modifier.clip(RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(Color(0xff79b791))
            ) {
                Text(text = "Daftar", color = Color.White)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "-- Atau --", fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))

            Button(
                onClick = {},
                modifier = Modifier.clip(RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(Color(0xff79b791))
            ) {
                Text(text = "Masuk dengan google", color = Color.White)
            }
        }
    }
}

