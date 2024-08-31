package com.example.bisolahfix

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController

@Composable
fun AyatKursiScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFFE8F5E9), Color(0xFF4CAF50))))
            .padding(16.dp)
    ) {
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


        // Konten halaman Ayat Kursi dengan scrollable
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .verticalScroll(rememberScrollState())
                .padding(top = 60.dp)
        ) {
            Text(
                text = "Ayat Kursi",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    shadow = Shadow(
                        color = Color(0x80000000),
                        blurRadius = 4f
                    )
                ),
                color = Color(0xFF00796B),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Ayat Kursi
            StyledAyatCard(
                title = "",
                arabicText = "اللّهُ لَا إِلٰهَ إِلَّا هُوَ الْحَيُّ الْقَيُّومُ لَا تَأْخُذُهُ سِنَةٌ وَلَا نَوْمٌ لَهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ مَنْ ذَا الَّذِي يَشْفَعُ عِندَهُ إِلَّا بِإِذْنِهِ يَعْلَمُ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ وَلَا يُحِيطُونَ بِشَيْءٍ مِنْ عِلْمِهِ إِلَّا بِمَا شَاءَ وَّسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالْأَرْضَ وَلَا يَؤُودُهُ حِفْظُهُمَا وَهُوَ الْعَلِيُّ الْعَظِيمُ",
                translation = "Allah, tidak ada Tuhan selain Dia, Yang Maha Hidup, Yang Kekal, Yang Mengurus (segala sesuatu). Tidak mengantuk dan tidak tidur. Milik-Nya apa yang ada di langit dan di bumi. Siapakah yang dapat memberi syafaat di sisi-Nya tanpa izin-Nya? Dia mengetahui apa yang ada di depan mereka dan apa yang ada di belakang mereka, dan mereka tidak mengetahui sesuatu apa pun dari ilmu-Nya kecuali apa yang Dia kehendaki. Kursi-Nya meliputi langit dan bumi. Dan tidak merasa berat memelihara keduanya. Dan Dia Maha Tinggi lagi Maha Besar."
            )
        }
    }
}

@Composable
fun StyledAyatCard(title: String, arabicText: String, translation: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFFB9FBC0), Color(0xFFC8E6C9))
                ),
                shape = RoundedCornerShape(15.dp)
            )
            .padding(20.dp)
            .shadow(8.dp, RoundedCornerShape(15.dp))
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall.copy(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF004D40)
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = arabicText,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 20.sp,
                lineHeight = 28.sp
            ),
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = translation,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 16.sp,
                color = Color(0xFF616161)
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
