package com.example.bisolahfix

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController

@Composable
fun NiatScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFFE8F5E9), Color(0xFF4CAF50))))
            .padding(16.dp)
    ) {
        // Tombol bulat home di pojok kiri atas
        IconButton(
            onClick = { navController.navigate("home") },
            modifier = Modifier
                .size(50.dp)
                .background(Color.White, RoundedCornerShape(50))
                .align(Alignment.TopStart)
                .shadow(4.dp, RoundedCornerShape(50))
                .zIndex(1f) // Menambah zIndex untuk memastikan di lapisan atas
        ) {
            Icon(
                painter = painterResource(id = R.drawable.iconback),
                contentDescription = "Home",
                tint = Color(0xFF4CAF50),
                modifier = Modifier.size(24.dp)
            )
        }

        // Konten halaman Niat dengan scrollable
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .verticalScroll(rememberScrollState()) // Menambahkan scroll
                .padding(top = 60.dp)
        ) {
            Text(
                text = "Niat Sholat",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                ),
                color = Color(0xFF00796B),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Niat Sholat Subuh
            NiatCard(
                title = "Niat Sholat Subuh",
                arabicText = "أُصَلِّي فَرْضَ الفَجْرِ رَكْعَتَيْنِ مُسْتَقْبِلَ الْقِبْلَةِ أَدَاءً للهِ تَعَالَى",
                translation = "Aku niat sholat fardhu Subuh dua rakaat menghadap kiblat karena Allah Ta'ala"
            )

            // Niat Sholat Dzuhur
            NiatCard(
                title = "Niat Sholat Dzuhur",
                arabicText = "أُصَلِّي فَرْضَ الظُّهْرِ أَرْبَعَ رَكْعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ أَدَاءً للهِ تَعَالَى",
                translation = "Aku niat sholat fardhu Dzuhur empat rakaat menghadap kiblat karena Allah Ta'ala"
            )

            // Niat Sholat Ashar
            NiatCard(
                title = "Niat Sholat Ashar",
                arabicText = "أُصَلِّي فَرْضَ العَصْرِ أَرْبَعَ رَكْعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ أَدَاءً للهِ تَعَالَى",
                translation = "Aku niat sholat fardhu Ashar empat rakaat menghadap kiblat karena Allah Ta'ala"
            )

            // Niat Sholat Maghrib
            NiatCard(
                title = "Niat Sholat Maghrib",
                arabicText = "أُصَلِّي فَرْضَ المَغْرِبِ ثَلَاثَ رَكْعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ أَدَاءً للهِ تَعَالَى",
                translation = "Aku niat sholat fardhu Maghrib tiga rakaat menghadap kiblat karena Allah Ta'ala"
            )

            // Niat Sholat Isya
            NiatCard(
                title = "Niat Sholat Isya",
                arabicText = "أُصَلِّي فَرْضَ العِشَاءِ أَرْبَعَ رَكْعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ أَدَاءً للهِ تَعَالَى",
                translation = "Aku niat sholat fardhu Isya empat rakaat menghadap kiblat karena Allah Ta'ala"
            )
        }
    }
}

@Composable
fun NiatCard(title: String, arabicText: String, translation: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(
                Brush.verticalGradient(listOf(Color(0xFFC8E6C9), Color(0xFFB9FBC0))),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(16.dp)
            .shadow(3.dp, RoundedCornerShape(1.dp))
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall.copy(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
            color = Color(0xFF004D40)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = arabicText,
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 18.sp),
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = translation,
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
            color = Color.DarkGray,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}
