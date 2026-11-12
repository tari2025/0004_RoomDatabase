package com.example.roomdata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.roomdata.ui.theme.RoomDataTheme
import com.example.roomdata.uicontroller.SiswaApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Opsional: enableEdgeToEdge() membuat aplikasi menggambar di belakang status bar
        enableEdgeToEdge()
        setContent {
            RoomDataTheme {
                // Surface digunakan sebagai container utama dengan warna background dari tema
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Memanggil fungsi navigasi utama aplikasi
                    SiswaApp()
                }
            }
        }
    }
}