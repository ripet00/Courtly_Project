package com.example.courtlyproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.courtlyproject.controller.MyAppNavigation
import com.example.courtlyproject.Feature.auth.presentation.viewModel.AuthViewModel
import com.example.courtlyproject.di.AppModule
import com.example.courtlyproject.ui.theme.CourtlyProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
                    Scaffold (){ innerpadding ->
                        val authViewModel : AuthViewModel by viewModels()


                        MyAppNavigation(modifier = Modifier.padding(innerpadding), authViewModel = authViewModel )
                    }
                }
            }
        }
    }
}
