package com.example.courtlyproject.controller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.courtlyproject.view.SplashScreen
import com.example.courtlyproject.auth.presentation.view.SignupPage
import com.example.courtlyproject.auth.presentation.view.WelcomingPage
import com.example.courtlyproject.view.HomeScreen
import com.example.courtlyproject.auth.presentation.view.LoginPage
import com.example.courtlyproject.MainActivity
import com.example.courtlyproject.auth.presentation.viewModel.AuthViewModel

@Composable
fun MyAppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splashscreen"){
        composable("splashscreen") {
            SplashScreen(navController, context = MainActivity())
        }
        composable("welcomingpage") {
            WelcomingPage( navController)
        }
        composable("login") {
            LoginPage(navController,authViewModel)
        }
        composable("signup") {
            SignupPage(modifier, navController, authViewModel)
        }
        composable("homepage") {
            HomeScreen( navController,authViewModel)
        }
    }
}