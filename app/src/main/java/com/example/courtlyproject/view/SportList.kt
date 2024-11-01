package com.example.courtlyproject.view

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
import androidx.compose.ui.unit.dp
import com.example.courtlyproject.view.componen_ui.ItemList
import com.example.courtlyproject.view.componen_ui.SportListItems
import com.example.courtlyproject.view.componen_ui.TopNaviagtion

@Composable
fun SportList(){
    val sports = listOf(
        SportListItems("Badminton","Ngeri"),
        SportListItems("Sepak Bola","Ngeri"),
        SportListItems("Volly","Ngeri"),
        SportListItems("Basket","Ngeri"),
        SportListItems("Mini soccer","Ngeri"),
        SportListItems("Tennis","Ngeri"),
        SportListItems("Futsal","Ngeri"),
        SportListItems("Golf","Ngeri")
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