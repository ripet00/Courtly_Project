package com.example.courtlyproject.pages

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.courtlyproject.AuthState
import com.example.courtlyproject.AuthViewModel
import com.example.courtlyproject.R

@Composable
fun LoginPage(navController: NavController, authViewModel: AuthViewModel) {
    var email by remember {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated -> navController.navigate("homepage")
            is AuthState.Error -> Toast.makeText(context,
                (authState.value as AuthState.Error).message,
                Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }

    Column {
        Image(
            painter = painterResource(id = R.drawable.group_82__1_),
            contentDescription = "Header",
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop,
        )
        Column (
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Silahkan Masuk",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Masukkan akun yang pernah kamu daftar!",
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.height(35.dp))

            //TextField utk Email
            OutlinedTextField(
                modifier = Modifier
                    .width(245.dp),
                value = email,
                onValueChange = { email = it },
                label = { Text("Masukkan Email", fontSize = 15.sp) },
                shape = RoundedCornerShape(32.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            //TextField utk Password
            OutlinedTextField(
                modifier = Modifier
                    .width(245.dp),
                value = password,
                onValueChange = { text -> password = text },
                visualTransformation = PasswordVisualTransformation(),
                label = { Text("Masukkan Kata Sandi", fontSize = 15.sp) },
                shape = RoundedCornerShape(32.dp)
            )

            Spacer(modifier = Modifier.height(80.dp))

            Button(onClick ={
                authViewModel.login(email,password)
            },
                enabled = authState.value != AuthState.Loading,
                modifier = Modifier
                    .width(245.dp)
                    .shadow(
                        elevation = 5.dp,
                        shape = RoundedCornerShape(16.dp), // Rounded corners for shadow
                        clip = true
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff79b791)
                )
            ) {
                Text(text = "Masuk")

            }

            Spacer(modifier = Modifier.height(5.dp))

            Row {
                Text("Belum buat akun?", fontSize = 15.sp)
                Spacer(modifier = Modifier.width(5.dp))
                ClickableText(
                    text = AnnotatedString(text = "Daftar"),
                    style = TextStyle(
                        color = Color(0xff79b791),
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                    ),
                    onClick = {
                        navController.navigate("signup")
                    }

                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun loginPagereview(){
//    LoginPage()
//}