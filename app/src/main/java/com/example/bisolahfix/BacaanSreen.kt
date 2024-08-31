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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController

@Composable
fun BacaanScreen(navController: NavController) {
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

        // Konten halaman Bacaan dengan scrollable
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .verticalScroll(rememberScrollState()) // Menambahkan scroll
                .padding(top = 60.dp)
        ) {
            Text(
                text = "Bacaan Sholat",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                ),
                color = Color(0xFF00796B),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Bacaan Sholat Subuh
            BacaanCard(
                title = "Doa Iftitah",
                arabicText = "اللّهُ أَكْبَرُ كَبِيرًا، وَالْحَمْدُ لِلَّهِ كَثِيرًا، وَسُبْحَانَ اللّهِ بُكْرَةً وَأَصِيلاً. إِنِّي وَجَّهْتُ وَجْهِيَ لِلَّذِي فَطَرَ السَّمَاوَاتِ وَالأَرْضَ حَنِيفًا وَمَا أَنَا مِنَ الْمُشْرِكِينَ. إِنَّ صَلاَتِي وَنُسُكِي وَمَحْيَايَ وَمَمَاتِي لِلَّهِ رَبِّ الْعَالَمِينَ، لاَ شَرِيكَ لَهُ وَبِذَلِكَ أُمِرْتُ وَأَنَا مِنَ الْمُسْلِمِينَ.",
                translation = "Allah Maha Besar, sangat besar. Segala puji bagi Allah yang sangat banyak. Maha Suci Allah pagi dan sore. Sesungguhnya aku menghadapkan wajahku kepada Allah yang menciptakan langit dan bumi, dalam keadaan hanif (murni) dan aku bukanlah termasuk orang-orang musyrik. Sesungguhnya sholatku, ibadahku, hidupku, dan matiku hanya untuk Allah, Tuhan seluruh alam. Tidak ada sekutu bagi-Nya. Demikianlah aku diperintahkan dan aku termasuk orang-orang Muslim."
            )

            // Bacaan Sholat Dzuhur
            BacaanCard(
                title = "Surat Al-Fatihah",
                arabicText = "بِسْمِ اللّهِ الرَّحْمَنِ الرَّحِيمِ ( * ) الْحَمْدُ للّهِ رَبِّ الْعَالَمِينَ (1) الرَّحْمـنِ الرَّحِيمِ (2) مَـلِكِ يَوْمِ الدِّينِ (3) إِيَّاكَ نَعْبُدُ وَإِيَّاكَ نَسْتَعِينُ (4) اهْدِنَا الصِّرَاطَ المُستَقِيمَ (5) صِرَاطَ الَّذِينَ أَنعَمتَ عَلَيهِمْ (6) غَيرِ المَغضُوبِ عَلَيهِمْ وَلاَ الضَّالِّينَ (7)غَيرِ المَغضُوبِ عَلَيهِمْ وَلاَ الضَّالِّينَ",
                translation = "Dengan nama Allah Yang Maha Pengasih lagi Maha Penyayang.\\nSegala puji bagi Allah, Tuhan seluruh alam.\\nYang Maha Pengasih lagi Maha Penyayang.\\nPemilik Hari Pembalasan.\\nHanya Engkau yang kami sembah, dan hanya kepada Engkau kami mohon pertolongan.\\nTunjukilah kami jalan yang lurus,\\n(yaitu) jalan orang-orang yang telah Engkau beri nikmat kepada mereka; bukan (jalan) mereka yang dimurkai, dan bukan (jalan) mereka yang sesat"
            )

            // Bacaan Sholat Ashar
            BacaanCard(
                title = "Ruku'",
                arabicText = "سُبْحَانَ رَبِّيَ الْعَظِيمِ وَبِحَمْدِهِ",
                translation = "Maha Suci Tuhan-ku Yang Maha Agung dan segala puji bagi-Nya.'"
            )

            // Bacaan Sholat Maghrib
            BacaanCard(
                title = "I'tidal",
                arabicText = "سَمِعَ اللّهُ لِمَنْ حَمِدَهُ، رَبَّنَا لَكَ الْحَمْدُ",
                translation = "Allah mendengar orang yang memuji-Nya. Ya Allah, bagi-Mu segala puji."
            )

            // Bacaan Sholat Isya
            BacaanCard(
                title = "Sujud",
                arabicText = "سُبْحَانَ رَبِّيَ الأَعْلَى وَبِحَمْدِهِ",
                translation = "Maha Suci Tuhan-ku Yang Maha Tinggi dan segala puji bagi-Nya."
            )

            // Bacaan Sholat Subuh
            BacaanCard(
                title = "Duduk di antara dua sujud",
                arabicText = "رَبِّ اغْفِرْ لِي وَارْحَمْنِي وَاجْبُرْنِي وَاهْدِنِي وَارْزُقْنِي وَعَافِنِي وَارْفَعْنِي",
                translation = "Ya Allah, ampunilah aku, rahmatilah aku, cukupkanlah aku, berilah petunjuk, berilah rezeki, berilah kesehatan, dan angkatlah derajatku."
            )

            // Bacaan Sholat Dzuhur
            BacaanCard(
                title = "Tasyahud Akhir",
                arabicText = "التَّحِيَّاتُ لِلّهِ وَالصَّلَوَاتُ وَالطَّيِّبَاتُ، السَّلاَمُ عَلَيْكَ أَيُّهَا النَّبِيُّ وَرَحْمَةُ اللّهِ وَبَرَكَاتُهُ، السَّلاَمُ عَلَيْنَا وَعَلَى عِبَادِ اللّهِ الصَّالِحِينَ، أَشْهَدُ أَنْ لاَ إِلَهَ إِلاَّ اللّهُ وَأَشْهَدُ أَنْ مُحَمَّدًا عَبْدُهُ وَرَسُولُهُ",
                translation = "Segala penghormatan, doa, dan kebaikan hanya untuk Allah. Salam sejahtera atasmu, wahai Nabi, serta rahmat dan berkah Allah. Salam sejahtera atas kami dan atas hamba-hamba Allah yang shalih. Aku bersaksi bahwa tidak ada Tuhan selain Allah, dan aku bersaksi bahwa Muhammad adalah hamba dan utusan-Nya."
            )

            // Bacaan Salam
            BacaanCard(
                title = "Salam",
                arabicText = "السَّلاَمُ عَلَيْكُمْ وَرَحْمَةُ اللّهِ",
                translation = "Salam sejahtera untuk kalian dan rahmat Allah."
            )
        }
    }
}

@Composable
fun BacaanCard(title: String, arabicText: String, translation: String) {
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
