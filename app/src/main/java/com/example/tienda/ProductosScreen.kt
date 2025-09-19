package com.example.tienda

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductListScreen(onCartClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "MiniTienda",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333),
                modifier = Modifier.align(Alignment.Center)
            )

            IconButton(
                onClick = onCartClick,
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.carrito),
                    contentDescription = "Carrito de compras",
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Productos Disponibles",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFF333333)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de productos
        val productos = listOf(
            Producto("P001", "Coca Cola 500ml", 2500, R.drawable.cocacola),
            Producto("P002", "Pan Integral", 1750, R.drawable.pan_integral),
            Producto("P003", "Leche Deslactosada 1L", 3000, R.drawable.leche_deslactosada)
        )

        productos.forEach { producto ->
            ProductItem(producto) {
                CarritoManager.agregarProducto(producto)
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ProductItem(producto: Producto, onAddClick: () -> Unit) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = Color.White,
        modifier = Modifier.fillMaxWidth(),
        shadowElevation = 2.dp
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = producto.imagenRes),
                contentDescription = producto.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(text = "Código: ${producto.codigo}", fontWeight = FontWeight.Bold, color = Color(0xFF333333))

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = producto.nombre, color = Color(0xFF666666))

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "$${producto.precio}", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF333333))

                Button(
                    onClick = onAddClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
                ) {
                    Text(text = "Agregar")
                }
            }
        }
    }
}