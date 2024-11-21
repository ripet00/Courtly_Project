package com.example.courtlyproject

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.courtlyproject.pages.FirstPage
import com.example.courtlyproject.pages.LoginPage
import com.example.courtlyproject.pages.SignupPage
import com.example.courtlyproject.pages.WelcomingPage
import com.example.courtlyproject.view.MainActivity

@Composable
fun MyAppNavigation(modifier: Modifier = Modifier,authViewModel: AuthViewModel, navController: NavHostController) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splashscreen"){
        composable("splashscreen") {
            SplashScreen(navController, context = MainActivity())
        }
        composable("login") {
            LoginPage(modifier, navController, authViewModel)
        }
        composable("signup") {
            SignupPage(modifier, navController, authViewModel)
        }
        composable("first") {
            WelcomingPage( navController)
        }
    }
}