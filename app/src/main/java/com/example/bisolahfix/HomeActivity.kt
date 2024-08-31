package com.example.bisolahfix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bisolahfix.ui.theme.BISOLAHFIXTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BISOLAHFIXTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        Modifier.padding(innerPadding)
                    ) {
                        composable("home") { HomeScreen(navController) }
                        composable("niat") { NiatScreen(navController) }
                        composable("bacaan") { BacaanScreen(navController) }
                        composable("ayat_kursi") { AyatKursiScreen(navController) }
                        composable("about") { AboutScreen(navController) }
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE5F7E1)), // Background hijau muda
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Bagian atas dengan sudut tumpul dan shadow
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clip(RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp))
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFF4CAF50), Color(0xFF81C784)) // Gradien hijau
                    )
                )
                .shadow(10.dp, RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp)) // Shadow untuk header
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            // Row untuk menempatkan gambar di samping kiri teks
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Gambar profil dengan shadow
                Image(
                    painter = painterResource(id = R.drawable.profile_picture), // Ganti dengan gambar profil Anda
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(90.dp)
                        .clip(CircleShape)
                        .border(4.dp, Color(0xFF00FF88), CircleShape) // Bingkai dengan kode warna Hex
                        .shadow(8.dp, CircleShape) // Shadow di gambar profil
                )

                Spacer(modifier = Modifier.width(16.dp)) // Spasi antara gambar dan teks

                // Kolom untuk teks
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    // Teks selamat datang
                    Text(
                        text = "Selamat Datang!",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    // Nama pengguna
                    Text(
                        text = "Fauzan Afif",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Start
                    )
                }
            }
        }

        // Bagian tengah: tiga gambar/ikon dengan navigasi
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp)
        ) {
            IconItem(navController, "niat", R.drawable.icon1, "Niat")
            IconItem(navController, "bacaan", R.drawable.icon2, "Bacaan")
            IconItem(navController, "ayat_kursi", R.drawable.icon3, "Ayat Kursi")
        }

        Spacer(modifier = Modifier.height(3.dp))

        // Bagian bawah: Navbar dengan 3 tombol dengan shadow
        BottomNavigationBar(navController)
    }
}

@Composable
fun IconItem(navController: NavController, route: String, iconRes: Int, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .clickable { navController.navigate(route) } // Navigasi saat diklik
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            modifier = Modifier.size(90.dp),
            tint = Color.Unspecified // Pastikan tidak ada tint yang menyebabkan masalah
        )
        Text(text = label, fontSize = 14.sp, textAlign = TextAlign.Center)
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)) // Membuat atas navbar tumpul
            .background(
                Brush.horizontalGradient(
                    colors = listOf(Color(0xFF4CAF50), Color(0xFF81C784)) // Gradien hijau untuk navbar
                )
            )
            .shadow(10.dp, RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)) // Shadow untuk navbar
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { navController.navigate("niat") }) {
                Icon(
                    painter = painterResource(id = R.drawable.bottom_icon1), // Ganti dengan ikon doa
                    contentDescription = "Doa",
                    modifier = Modifier.size(40.dp),
                    tint = Color.Unspecified // Pastikan tidak ada tint yang menyebabkan masalah
                )
            }
            IconButton(onClick = { navController.navigate("home") }) {
                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .shadow(10.dp, CircleShape), // Shadow untuk tombol home
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.bottom_icon_home), // Pastikan file ini ada di res/drawable
                        contentDescription = "Home",
                        modifier = Modifier.size(50.dp),
                        tint = Color.Unspecified // Pastikan tidak ada tint yang menyebabkan masalah
                    )
                }
            }

            IconButton(onClick = { navController.navigate("about") }) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .shadow(10.dp, CircleShape), // Shadow untuk tombol home
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.img_1), // Ganti dengan ikon tentang
                        contentDescription = "About",
                        modifier = Modifier.size(100.dp), // Ganti ukuran ikonnya sesuai keinginan
                        tint = Color.Unspecified // Pastikan tidak ada tint yang menyebabkan masalah
                    )

                }
        }
    }
    }
}
