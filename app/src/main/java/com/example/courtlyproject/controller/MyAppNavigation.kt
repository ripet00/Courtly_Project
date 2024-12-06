package com.example.courtlyproject.controller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.courtlyproject.Feature.auth.presentation.viewModel.AuthViewModel
import com.example.courtlyproject.view.SplashScreen
import com.example.courtlyproject.Feature.auth.presentation.view.LoginPage
import com.example.courtlyproject.MainActivity
import androidx.navigation.navArgument
import com.example.courtlyproject.Feature.auth.presentation.view.SignupPage
import com.example.courtlyproject.Feature.auth.presentation.view.WelcomingPage
import com.example.courtlyproject.Feature.detail.view.HomeScreen
import com.example.courtlyproject.Feature.detail.view.detailcontent
import com.example.courtlyproject.user.presentation.view.PesananScreen
import com.example.courtlyproject.user.presentation.view.UserProfileScreen


@Composable
fun MyAppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splashscreen"){
        composable("splashscreen") {
            SplashScreen(navController, context = MainActivity())
        }
        composable("welcoming page") {
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
        composable("userprofile") {
            UserProfileScreen( navController)
        }
        composable("user order") {
            PesananScreen( navController)
        }
        composable(
            route = "detail/{lapanganId}",
            arguments = listOf(navArgument("lapanganId") {
                type = NavType.StringType
            })
        ){
            // proses passing id
            backStackEntry ->
            val lapanganId = backStackEntry.arguments?.getString("lapanganId")
            detailcontent(navController = navController, lapanganId = lapanganId.toString())
        }
    }
}