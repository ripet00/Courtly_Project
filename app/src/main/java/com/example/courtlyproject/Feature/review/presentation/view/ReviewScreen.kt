package com.example.courtlyproject.Feature.review.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.courtlyproject.R
import androidx.compose.material3.Icon
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.courtlyproject.Feature.review.domain.model.Review

@Composable
fun ReviewScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Header section
        HeaderSection()
        Spacer(modifier = Modifier.height(8.dp))
        Divider(
            color = Color.LightGray,
            thickness = 2.dp,
            modifier = Modifier.width(350.dp).align(alignment = Alignment.CenterHorizontally),

        )
        // List of reviews
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(sampleReviews) { review ->
                ReviewItem(review)
                Divider(
                    color = Color.LightGray,
                    thickness = 8.dp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun HeaderSection() {
    Column (modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)){
        Row (verticalAlignment = Alignment.CenterVertically){
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "backNavIcon",
                Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Ulasan",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Row(
                verticalAlignment = Alignment.Top
            ) {
                // Lapangan Image
                Image(
                    painter = painterResource(id = R.drawable.stadium), // Placeholder for lapangan image
                    contentDescription = "Lapangan Image",
                    modifier = Modifier
                        .size(72.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .padding(top=4.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))

                // Lapangan Info
                Column (modifier = Modifier.width(200.dp)){
                    Text(
                        text = "Lapangan Teknik",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Basket, Futsal, Voli, Bulutangkis",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                    Text(
                        text = "Jl. Poros Malino, no. 09, Kabupaten Gowa",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
            }

            // Rating
            Row(verticalAlignment = Alignment.CenterVertically , modifier = Modifier) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Rating",
                    tint = Color(color = 0xFFFFC107),
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "4.7",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
fun ReviewItem(review: Review) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent // Warna background Card
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            // Reviewer info
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.nand), // Placeholder for avatar
                        contentDescription = "Avatar",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = review.name,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                            )
                        Text(
                            text = review.date,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                    }
                }
                Spacer(modifier = Modifier.width(120.dp))
                RatingStars(rating = review.rating)
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Review text
            Text(text = review.comment, style = MaterialTheme.typography.bodyLarge)

            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.ThumbUp,
                    contentDescription = "icon like"
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Membantu",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
fun RatingStars(rating: Int) {
    Row {
        repeat(5) { index ->
            Icon(
                imageVector =Icons.Default.Star,
                contentDescription = null,
                tint =  if (index < rating) Color(0xFFFFC107) else Color.LightGray,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

val sampleReviews = listOf(
    Review("cyputimoet", "17 Jan 2024", 4, "agak\" sih tpi... gtW ya hmch ihhhh tpi keren loh lapangannya"),
    Review("chrstymaniez", "13 Jan 2024", 2, "gtaw sih mw kasi reting afih, krn td di lpangan gada cogan ny sm skli..."),
    Review("raishaaawww", "13 Jan 2024", 5, "Uwaaaaaa, Ak td Ktm Cwo GANTEEENNNGG BANGETTTT, WAJIB BINTANG 5555555!!!!!")
)

@Preview(showBackground = true, showSystemUi = true)
@Composable

private fun ReviewScreenPreview(){
    ReviewScreen()
}
