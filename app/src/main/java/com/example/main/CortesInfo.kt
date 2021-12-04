package com.example.main

class CortesInfo (
    val cortes: List <CortesModel>
)

data class CortesModel (
    val fecha: String,
    val monto: Double
)