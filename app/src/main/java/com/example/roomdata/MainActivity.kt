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
// Pastikan untuk meng-import SiswaApp dari package yang sesuai
// Jika PetaNavigasi.kt berada di package uicontroller:
// import com.example.roomdata.uicontroller.SiswaApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoomDataTheme {
                // Menggunakan Surface agar background mengikuti tema
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Memanggil navigasi utama aplikasi Anda
                    SiswaApp()
                }
            }
        }
    }
}