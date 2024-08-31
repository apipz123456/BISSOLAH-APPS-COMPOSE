package com.example.bisolahfix

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.zIndex
import androidx.navigation.NavController

@Composable
fun AboutScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp)
            .background(Brush.verticalGradient(listOf(Color(0xFFE8F5E9), Color(0xFF4CAF50))))

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(35.dp)) // Add space to offset the icon at the top
            Text(
                text = "Tentang Developer",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF004D40),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))

            Surface(
                modifier = Modifier
                    .size(140.dp)
                    .shadow(10.dp, shape = CircleShape)
                    .background(
                        Brush.linearGradient(
                            listOf(Color(0xFF80DEEA), Color(0xFF4CAF50))
                        ), shape = CircleShape
                    )
                    .padding(4.dp),
                shape = CircleShape,
                color = Color.Transparent
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                        .background(Color(0xFF4CAF50)), // Green background color for the circle
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile_picture), // Placeholder icon
                        contentDescription = "Placeholder Icon",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(124.dp)
                            .clip(CircleShape)
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Aplikasinya dirancang oleh Fauzan Afif Lutfiansah mahasiswa Universitas Darussalam Gontor untuk membantu kita dalam perjalanan spiritual harian.",
                fontSize = 16.sp,
                color = Color(0xFF004D40),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),

                colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F2F1))
            ) {
                Text(
                    text = "\"Not Can't But Can't Yet, soo.? Trying is The Key for Success in Your Life\" - Ojan -",
                    fontSize = 16.sp,
                    color = Color(0xFF00796B),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { /* Navigate to feedback form */ },
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Punya Saran?",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF004D40)
                    )
                    Text(
                        text = "Kami menghargai masukan Anda. Klik di sini untuk membagikan pemikiran Anda!",
                        fontSize = 14.sp,
                        color = Color(0xFF00796B),
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "Version 1.0.0",
                fontSize = 14.sp,
                color = Color(0xFF004D40)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Dibuat Oleh: Fauzan Afif Lutfiansah",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF004D40),
                modifier = Modifier.clickable { /* Navigate to LinkedIn profile */ }
            )
            Text(
                text = "LinkedIn",
                fontSize = 14.sp,
                color = Color(0xFF00796B),
                textAlign = TextAlign.Center,
                modifier = Modifier.clickable { /* Navigate to LinkedIn profile */ }
            )
        }

        // Tombol bulat home di pojok kiri atas
        IconButton(
            onClick = { navController.navigate("home") },
            modifier = Modifier
                .size(50.dp)
                .background(Color.White, RoundedCornerShape(50))
                .align(Alignment.TopStart) // Aligns the button to the top start
                .shadow(4.dp, RoundedCornerShape(50))
                .zIndex(1f)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.iconback),
                contentDescription = "Home",
                tint = Color(0xFF4CAF50),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

