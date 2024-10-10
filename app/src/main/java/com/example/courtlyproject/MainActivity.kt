package com.example.courtlyproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.courtlyproject.ui.theme.CourtlyProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val authViewModel : AuthViewModel by viewModels()
        setContent {
            CourtlyProjectTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    val navController = rememberNavController()
//
//                    NavHost(navController = navController, startDestination = "Splash") {
//                        composable("Splash") {
//                            SplashScreen(navController = navController, context = this@MainActivity)
//                        }
////                        composable("Onboarding") {
////                            OnboardingScreen(navController = navController, context = this@MainActivity)
////                        }
////                        composable("Home") {
////                            HomeScreen()
////                        }
//                    }
//                }

                Scaffold ( modifier = Modifier.fillMaxSize()) {  innerPadding ->
                    MyAppNavigation(modifier = Modifier.padding(innerPadding),  authViewModel = authViewModel)
                }


            }
        }
    }
}



