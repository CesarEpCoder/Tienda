package com.example.tienda

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CarritoScreen(onBackClick: () -> Unit) {
    val productos = CarritoManager.obtenerProductos()
    val total = CarritoManager.calcularTotal()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Carrito",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        if (productos.isEmpty()) {
            Text(text = "Tu carrito está vacío")
        } else {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(productos) { producto ->
                    Text(
                        text = "${producto.nombre} - $${producto.precio}",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Total: $$total", fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onBackClick) {
            Text(text = "Volver a la principal")
        }
    }
}




