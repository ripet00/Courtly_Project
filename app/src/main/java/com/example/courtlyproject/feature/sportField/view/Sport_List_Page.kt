package com.example.courtlyproject.feature.sportField.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.courtlyproject.feature.sportField.model.SportListItems
import com.example.courtlyproject.feature.componen_ui.ItemList
import com.example.courtlyproject.feature.componen_ui.TopNaviagtion
import com.example.courtlyproject.R


@Composable
fun SportList(navController: NavController){
    val sports = listOf(
        SportListItems(
            icon = painterResource(R.drawable.welllogo),
            title= "Badminton",
            desc = "Ngeri"),
        SportListItems(
            icon = painterResource(R.drawable.welllogo),
            title= "Badminton",
            desc = "Ngeri"),
        SportListItems(
            icon = painterResource(R.drawable.welllogo),
            title= "Badminton",
            desc = "Ngeri"),
        SportListItems(
            icon = painterResource(R.drawable.welllogo),
            title= "Badminton",
            desc = "Ngeri"),
        SportListItems(
            icon = painterResource(R.drawable.welllogo),
            title= "Badminton",
            desc = "Ngeri"),
        SportListItems(
            icon = painterResource(R.drawable.welllogo),
            title= "Badminton",
            desc = "Ngeri"),
        SportListItems(
            icon = painterResource(R.drawable.welllogo),
            title= "Badminton",
            desc = "Ngeri"),
    )
    Column (
        modifier = Modifier
            .background(color = Color.White)
    ){
        TopNaviagtion("Daftar Olahraga")
        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(contentPadding = PaddingValues(16.dp)) {
            items(sports) { sport ->
                ItemList(sport)
            }
        }
    }
}