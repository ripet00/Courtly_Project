package com.example.courtlyproject.Feature.auth.presentation.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.courtlyproject.R


@Composable
fun WelcomingPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(90.dp))

        MainImageSection()

        DescriptionText()

        Spacer(modifier = Modifier.height(40.dp))

        ButtonsSection(navController)

        Spacer(modifier = Modifier.height(30.dp))

        // Login Link
        LoginLink(navController = navController)
    }
}


@Composable
fun MainImageSection() {
    Column {
        Row {
            Image(
                painter = painterResource(id = R.drawable.particle), // Replace with actual image
                contentDescription = "Main Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(35.dp)
                    .padding(start = 10.dp, top = 20.dp)// Adjust this value as needed to make the image smaller
                // Add padding for white space on the sides
            )
            Image(
                painter = painterResource(id = R.drawable.welllogo), // Replace with actual image
                contentDescription = "Main Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(270.dp) // Adjust this value as needed to make the image smaller
                    .padding(horizontal = 16.dp) // Add padding for white space on the sides
            )
            Image(
                painter = painterResource(id = R.drawable.particle), // Replace with actual image
                contentDescription = "Main Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(30.dp) // Adjust this value as needed to make the image smaller
                // Add padding for white space on the sides
            )
        }
        Image(
            painter = painterResource(id = R.drawable.particles2), // Replace with actual image
            contentDescription = "Main Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(70.dp) // Adjust this value as needed to make the image smaller
                .padding(horizontal = 16.dp) // Add padding for white space on the sides
        )
    }
}

@Composable
fun DescriptionText() {
    Text(
        text = "Temukan lapangan impianmu. Reservasi mudah, main lebih seru!",
        fontSize =20.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF79B791),
        textAlign = TextAlign.Center,
        modifier = Modifier.width(250.dp)
    )
}

@Composable
fun ButtonsSection(navController: NavController) {
    // Sign Up Button
    Button(
        onClick = {
            navController.navigate("signup")
        },
        modifier = Modifier
            .width(300.dp)
            .height(48.dp)
            .shadow(
                elevation = 9.dp,// Adjust the shadow elevation
                shape = RoundedCornerShape(16.dp), // Rounded corners for shadow
                clip = true
            ),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF79B791)) // Green color
    ) {
        Text(text = "Daftar", fontSize = 15.sp, color = Color.White)
    }

    Spacer(modifier = Modifier.height(18.dp))

    // Google Sign In Button
    Button(
        onClick = { /* Handle Google Sign In */ },
        modifier = Modifier
//            .fillMaxWidth()
            .height(48.dp)
            .width(300.dp)
            .shadow(
                elevation = 9.dp, // Adjust the shadow elevation
                shape = RoundedCornerShape(16.dp), // Rounded corners for shadow
                clip = true
            ),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF79B791)) // Green color
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.goolgelogo), // Replace with Google logo
                contentDescription = "Google Logo",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(9.dp))
            Text(text = "Masuk dengan Google", fontSize = 15.sp, color = Color.White)
        }
    }
}

@Composable
fun LoginLink(navController : NavController) {
    Text(
        text = "Masuk >",
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF79B791),
        modifier = Modifier.clickable {
            navController.navigate("Login")
        }
    )
}