package com.example.courtlyproject.controller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.courtlyproject.Feature.auth.AuthViewModel
import com.example.courtlyproject.Feature.auth.LoginPage
import com.example.courtlyproject.Feature.auth.SignupPage
import com.example.courtlyproject.Feature.auth.WelcomingPage
import com.example.courtlyproject.Feature.detail.view.detailcontent
import com.example.courtlyproject.view.HomeScreen
import com.example.courtlyproject.view.MainActivity
import com.example.courtlyproject.view.SplashScreen

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
        composable("detail") {
            detailcontent(navController = navController, detaillapanganViewModel = viewModel())
        }
    }
}