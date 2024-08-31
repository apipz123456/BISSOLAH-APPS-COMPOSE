package com.example.bisolahfix

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.delay
import com.example.bisolahfix.ui.theme.BISOLAHFIXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BISOLAHFIXTheme {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent() {
    // Get the context
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        delay(2000) // Delay for 2 seconds

        // Start HomeActivity
        val intent = Intent(context, HomeActivity::class.java)
        context.startActivity(intent)

        // If you're using the same activity, finishing is optional
        if (context is ComponentActivity) {
            context.finish()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Pastikan resource ID gambar sudah benar
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Default Logo",
                modifier = Modifier.size(400.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    BISOLAHFIXTheme {
        MainContent()
    }
}
