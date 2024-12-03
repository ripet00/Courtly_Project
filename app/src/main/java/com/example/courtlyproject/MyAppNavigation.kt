package com.example.courtlyproject

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.courtlyproject.Feature.login_signup.view.LoginPage
import com.example.courtlyproject.Feature.login_signup.view.SignupPage
import com.example.courtlyproject.pages.FirstPage
import com.example.courtlyproject.view.MainActivity

//import com.example.courtlyproject.view.HomePage

@Composable
fun MyAppNavigation(modifier: Modifier = Modifier,authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splashscreen"
    ){
        composable("splashscreen") {
            SplashScreen(navController, context = MainActivity())
        }
        composable("login") {
            LoginPage(navController)
        }
//        composable("login") {
//            LoginPage(modifier, navController, authViewModel)
//        }
        composable("signup") {
            SignupPage(modifier, navController, authViewModel)
        }
        composable("welcomingPage") {
            FirstPage(modifier, navController, authViewModel)
        }

    }
}