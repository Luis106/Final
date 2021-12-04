package com.example.main

class ProductosInfo (
    val productos: MutableList <ProductosModel>
)

data class ProductosModel (
    val name: String,
    val price: Double,
    val storage: Double
)