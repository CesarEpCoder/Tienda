package com.example.tienda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.tienda.ui.theme.TiendaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TiendaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF5F5F5)
                ) {
                    var showCart by remember { mutableStateOf(false) }

                    if (showCart) {
                        CarritoScreen(
                            onBackClick = { showCart = false }
                        )
                    } else {
                        ProductListScreen(
                            onCartClick = { showCart = true }
                        )
                    }
                }
            }
        }
    }
}

