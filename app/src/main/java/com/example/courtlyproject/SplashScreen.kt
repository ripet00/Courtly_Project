package com.example.courtlyproject

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController, context: MainActivity) {


    val alpha = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        alpha.animateTo(1f, animationSpec = tween(2500))
        delay(4000)
        navController.popBackStack() // to close the splash screen after finish, so if we go back from onboarding screen it will automatically show your desktop
        navController.navigate("login")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xff1B4531))
        , verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(painter = painterResource(id=R.drawable.courtly),
            contentDescription = "logo")
//        LoaderAnimation(
//            modifier = Modifier. size(400.dp)
//            ,anim = R.raw.mobile_app
//        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(text = "Let's make an App", modifier = Modifier.alpha(alpha.value) ,fontSize = 32.sp, color = Color.White)
    }
}

@Composable
fun LoaderAnimation(modifier: Modifier, anim: Int) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(anim))

    LottieAnimation(composition = composition, iterations =  LottieConstants.IterateForever,
        modifier = modifier)
}

//@Preview
//@Composable
//private fun splashPrev() {
//    SplashScreen()
//
//}