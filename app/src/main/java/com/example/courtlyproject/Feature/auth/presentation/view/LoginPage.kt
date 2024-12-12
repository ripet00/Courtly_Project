package com.example.courtlyproject.Feature.auth.presentation.view

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.courtlyproject.R
import com.example.courtlyproject.Feature.auth.presentation.viewModel.AuthState
import com.example.courtlyproject.Feature.auth.presentation.viewModel.AuthViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

@Composable
fun LoginPage(navController: NavController, authViewModel: AuthViewModel = hiltViewModel()) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val authState = authViewModel.authState.collectAsState()
    val context = LocalContext.current

    // Configure Google Sign-In
    val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(context.getString(R.string.default_web_client_id))
        .requestEmail()
        .build()
    val googleSignInClient: GoogleSignInClient = GoogleSignIn.getClient(context, googleSignInOptions)

    // Google Sign-In Launcher
    val googleSignInLauncher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account = task.result
            if (account != null) {
                val idToken = account.idToken
                if (idToken != null) {
                    authViewModel.loginWithGoogle(idToken)
                }
            }
        } catch (e: Exception) {
            Log.e("LoginPage", "Google Sign-In Failed", e)
        }
    }

    // Handle Authentication State
    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Authenticated -> navController.navigate("homepage")
            is AuthState.Error -> Toast.makeText(context, (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Header Image
        Image(
            painter = painterResource(id = R.drawable.group_82__1_),
            contentDescription = "Header",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.height(70.dp))

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 46.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Login Title
            Text(
                text = "Silahkan Masuk",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Masukkan akun yang pernah kamu daftar!", fontSize = 15.sp)

            Spacer(modifier = Modifier.height(20.dp))

            // Email Input
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Masukkan Email") },
                shape = RoundedCornerShape(32.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Password Input
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Masukkan Kata Sandi") },
                visualTransformation = PasswordVisualTransformation(),
                shape = RoundedCornerShape(32.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Login Button
            Button(
                onClick = { authViewModel.loginWithEmail(email, password) },
                enabled = authState.value != AuthState.Loading,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF79B791))
            ) {
                Text(text = "Masuk", fontSize = 16.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Divider Text
            Text(text = "-- Atau --", fontSize = 14.sp, color = Color.Gray)

            Spacer(modifier = Modifier.height(10.dp))

            // Google Sign-In Button
            Button(
                onClick = { googleSignInLauncher.launch(googleSignInClient.signInIntent) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF79B791))
            ) {
                Row(verticalAlignment = Alignment.CenterVertically ) {
                    Image(
                        painter = painterResource(id = R.drawable.goolgelogo),
                        contentDescription = "Google Logo",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Masuk dengan Google", fontSize = 15.sp, color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Signup Link
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Belum punya akun?", fontSize = 15.sp)
                Spacer(modifier = Modifier.width(4.dp))
                ClickableText(
                    text = AnnotatedString("Daftar"),
                    style = TextStyle(color = Color(0xFF79B791), fontSize = 15.sp),
                    onClick = { navController.navigate("signup") }
                )
            }
        }
    }
}
