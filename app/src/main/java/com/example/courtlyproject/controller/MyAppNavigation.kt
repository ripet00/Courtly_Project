package com.example.courtlyproject.controller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.courtlyproject.Feature.auth.presentation.view.LoginPage
import com.example.courtlyproject.Feature.auth.presentation.view.SignupPage
import com.example.courtlyproject.Feature.auth.presentation.view.WelcomingPage
import com.example.courtlyproject.Feature.auth.presentation.viewModel.AuthViewModel
import com.example.courtlyproject.Feature.detail.view.HomeScreen
import com.example.courtlyproject.Feature.detail.view.detailcontent
import com.example.courtlyproject.MainActivity
import com.example.courtlyproject.di.AppModule
import com.example.courtlyproject.user.presentation.view.UserProfileScreen
import com.example.courtlyproject.view.SplashScreen
import com.google.firebase.auth.FirebaseAuth


@Composable
fun MyAppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    val userId = FirebaseAuth.getInstance().currentUser?.uid
    val viewModel = AppModule.provideUserProfileViewModel()

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
            if (userId != null) {
                UserProfileScreen( navController,viewModel = viewModel, userId = userId, authViewModel = authViewModel)
            }
        }
//        composable("user order") {
//            PesananScreen( navController)
//        }
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
