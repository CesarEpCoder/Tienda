package com.example.tienda

object CarritoManager {
    private val productosEnCarrito = mutableListOf<Producto>()

    fun agregarProducto(producto: Producto) {
        productosEnCarrito.add(producto)
    }

    fun quitarProducto(producto: Producto) {
        productosEnCarrito.remove(producto)
    }

    fun obtenerProductos(): List<Producto> {
        return productosEnCarrito
    }

    fun calcularTotal(): Int {
        return productosEnCarrito.sumOf { it.precio }
    }
}
