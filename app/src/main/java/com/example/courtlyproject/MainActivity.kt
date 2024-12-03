package com.example.courtlyproject.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.courtlyproject.AuthViewModel
import com.example.courtlyproject.Feature.login_signup.view.LoginPage
import com.example.courtlyproject.Feature.login_signup.view.WelcomingPage
import com.example.courtlyproject.SplashScreen
import com.example.courtlyproject.ui.theme.CourtlyProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CourtlyProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "Splash") {
                        composable("Splash") {
                            SplashScreen(navController = navController, context = this@MainActivity)
                        }
                        composable("welcomingPage") {
                            WelcomingPage(navController)
                        }
                        composable("LoginPage") {
                            LoginPage(navController, authViewModel = AuthViewModel())
                        }

//                        composable("Onboarding") {
//                            OnboardingScreen(navController = navController, context = this@MainActivity)
//                        }
//                        composable("Home") {
//                            HomeScreen()
//                        }
                    }
                }


            }
        }
    }
}