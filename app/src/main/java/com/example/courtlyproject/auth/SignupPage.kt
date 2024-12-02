package com.example.courtlyproject.auth

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.courtlyproject.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

@Composable
fun SignupPage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {
    var email by remember { mutableStateOf("") }
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var repeatPassword by rememberSaveable { mutableStateOf("") }
    var nomorHp by rememberSaveable { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    // Google Sign-In
    val googleSignInClient: GoogleSignInClient = GoogleSignIn.getClient(
        context,
        GoogleSignInOptions.DEFAULT_SIGN_IN
    )

    LaunchedEffect(authState.value) {
        when(authState.value) {
            is AuthState.Authenticated -> navController.navigate("homepage")
            is AuthState.Error -> Toast.makeText(context,
                (authState.value as AuthState.Error).message,
                Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.group_82__1_),
            contentDescription = "logo",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Pendaftaran", fontSize = 32.sp)
            Text(text = "Mohon isi data berikut dengan benar", fontSize = 16.sp)

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Masukkan Email", fontSize = 15.sp) },
                shape = RoundedCornerShape(32.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Nama Pengguna", fontSize = 15.sp) },
                shape = RoundedCornerShape(32.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Kata Sandi", fontSize = 15.sp) },
                shape = RoundedCornerShape(32.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))

            if (errorMessage.isNotEmpty() && repeatPassword.isNotEmpty()) {
                Text(text = errorMessage, color = MaterialTheme.colorScheme.error, fontStyle = FontStyle.Italic)
                Spacer(modifier = Modifier.height(8.dp))
            }
            OutlinedTextField(
                value = repeatPassword,
                onValueChange = { repeatPassword = it },
                label = { Text("Masukkan ulang kata sandi", fontSize = 15.sp) },
                shape = RoundedCornerShape(32.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                value = nomorHp,
                onValueChange = { nomorHp = it },
                label = { Text("No Handphone", fontSize = 15.sp) },
                shape = RoundedCornerShape(32.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))

            // Sign Up Button
            Button(
                onClick = {
                    if(password == repeatPassword){
                        authViewModel.signup(
                            username = username,
                            email = email,
                            password = password,
                            repeatPassword = repeatPassword,
                            nomorHp = nomorHp
                        )
                    }else{
                        errorMessage = "Konfirmasi Password Tidak sesuai"
                    }
                },
                enabled = authState.value != AuthState.Loading,
                modifier = Modifier
                    .width(300.dp)
                    .height(48.dp)
                    .shadow(
                        elevation = 9.dp,
                        shape = RoundedCornerShape(16.dp),
                        clip = true
                    ),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF79B791))
            ) {
                Text(text = "Daftar", fontSize = 15.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "-- Atau --", fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))

            // Google Sign In Button
            Button(
                onClick = {
                    val signInIntent = googleSignInClient.signInIntent
                    (context as Activity).startActivityForResult(signInIntent, RC_SIGN_IN)
                },
                modifier = Modifier
                    .height(48.dp)
                    .width(300.dp)
                    .shadow(
                        elevation = 9.dp,
                        shape = RoundedCornerShape(16.dp),
                        clip = true
                    ),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF79B791))
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.goolgelogo),
                        contentDescription = "Google Logo",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(9.dp))
                    Text(text = "Masuk dengan Google", fontSize = 15.sp, color = Color.White)
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Sudah punya akun?", fontSize = 15.sp)
                Spacer(modifier = Modifier.width(5.dp))
                ClickableText(
                    text = AnnotatedString(text = "masuk sini"),
                    style = TextStyle(
                        color = Color(0xff79b791),
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                    ),
                    onClick = {
                        navController.navigate("login")
                    }
                )
            }
        }
    }
}

// Add this constant to handle Google Sign-In request result
private const val RC_SIGN_IN = 9001