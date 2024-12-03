package com.example.courtlyproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun RegistrationScreen() {
    var email by remember {
        mutableStateOf(mutableSetOf(""))
    }
    var username by rememberSaveable {
        mutableStateOf(mutableSetOf(""))
    }
    var password by remember {
        mutableStateOf(mutableSetOf(""))
    }
    var confirmPassword by remember {
        mutableStateOf(mutableSetOf(""))
    }
    var phoneNumber by remember {
        mutableStateOf("")
    }
    var passwordVisible by remember {mutableStateOf(false)}

    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFE0E0E0))
    ) {
        Image(
            painter = painterResource(id = R.drawable.balls_sports_2),
            contentDescription = "Background",
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Fit
        )
    }
}


