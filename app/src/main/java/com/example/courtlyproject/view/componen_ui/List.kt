package com.example.courtlyproject.view.componen_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courtlyproject.R

@Composable
fun ItemList(sport : SportListItems){
    Row (
        modifier = Modifier
    ){
        Image(
            painter = painterResource(id = R.drawable.welllogo),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .size(50.dp)
                .padding(top = 3.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()

        ) {
            Text(
                text = "${sport.title}",
                style = MaterialTheme.typography.titleMedium,
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 8.dp, top = 4.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "${sport.desc}",
                style = MaterialTheme.typography.bodySmall,
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 8.dp)
            )
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = 2.dp,                     // Ketebalan garis
                color = Color.Black // Warna garis
            )
        }
    }
}



data class SportListItems(val title : String, val desc : String)