package com.example.courtlyproject.controller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.courtlyproject.AuthViewModel
import com.example.courtlyproject.view.SplashScreen
import com.example.courtlyproject.pages.SignupPage
import com.example.courtlyproject.pages.WelcomingPage
import com.example.courtlyproject.view.HomeScreen
import com.example.courtlyproject.pages.LoginPage
import com.example.courtlyproject.view.MainActivity

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