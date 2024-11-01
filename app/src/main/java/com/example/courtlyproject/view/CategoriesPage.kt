package com.example.courtlyproject.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.courtlyproject.view.componen_ui.SportPlaceList
import com.example.courtlyproject.view.componen_ui.TopNaviagtion


@Composable
fun Categories(){
    Column (
        modifier = Modifier
            .background(color = Color.White)
    ) {
        TopNaviagtion("Basket")
        Spacer(modifier = Modifier.height(20.dp))
        SportPlaceList()
    }
}