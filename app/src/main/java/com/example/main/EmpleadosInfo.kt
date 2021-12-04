package com.example.main

class EmpleadosInfo (
    val empleados: List <EmpleadosModel>
)

data class EmpleadosModel (
    val name: String,
    val range: String,
    val ultimaEn: String,
    val creacion: String

)