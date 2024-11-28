package com.example.courtlyproject.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.courtlyproject.AuthViewModel
import com.example.courtlyproject.R

@Composable
fun LoginPage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {
    var email by remember {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    Image(
        painter = painterResource(id = R.drawable.logo_courtly),
        contentDescription = "Atasan"
    )
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = modifier.height(20.dp))
        Text(
            text = "Silahkan Masuk",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        //Spacer(modifier = modifier.height(2.dp))
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
            onValueChange = { text -> email = text },
            label = { Text("Masukkan Email", fontSize = 15.sp) }
        )
        Spacer(modifier = Modifier.height(10.dp))

        //TextField utk Password
        OutlinedTextField(
            modifier = Modifier
                .width(245.dp),
            value = password,
            onValueChange = { text -> password = text },
            visualTransformation = PasswordVisualTransformation(),
            label = { Text("Masukkan Kata Sandi", fontSize = 15.sp) }
        )
        Spacer(modifier = Modifier.height(80.dp))
        Button(onClick ={
            navController.navigate("HomePage")
        },
            modifier = Modifier.width(245.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff79b791)
            )
        ) {
            Text(text = "Masuk")

        }
        Row {
            Text("Belum buat akun?", fontSize = 15.sp)
            Spacer(modifier = Modifier.width(5.dp))
            ClickableText(
                text = AnnotatedString(text = "Daftar"),
                style = TextStyle(
                    color = Color(0xff1B4531),
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center
                ),
                onClick = {
                    navController.navigate("signup")
                }
            )
        }

    }



    @Composable
    fun SimpleComposable() {
        Row {
            Text("Belum buat akun?", fontSize = 15.sp)
            Spacer(modifier = Modifier.width(5.dp))
            ClickableText(
                text = AnnotatedString(text = "Daftar"),
                style = TextStyle(
                    color = Color(0xff1B4531),
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center
                ),
                onClick = {
                }

            )
        }}

//    val String.color
//    get() = Color(parseColor(this))

}