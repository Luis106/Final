package com.example.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class AdminMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_main)

        val btnCortes: Button = findViewById(R.id.btnCortes)
        btnCortes.setOnClickListener {
            Log.d("Button", "Cortes.")
            val intent = Intent(this, Cortes::class.java).apply {
            }
            startActivity(intent)
        }

        val btnProductos: Button = findViewById(R.id.btnProductos)
        btnProductos.setOnClickListener {
            Log.d("Button", "Productos.")
            val intent = Intent(this, Productos::class.java).apply {
            }
            startActivity(intent)
        }

        val btnEmpleados: Button = findViewById(R.id.btnEmpleados)
        btnEmpleados.setOnClickListener {
            Log.d("Button", "Empleados.")
            val intent = Intent(this, Empleados::class.java).apply {
            }
            startActivity(intent)
        }

        val btnBack: Button = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            Log.d("Button", "Regreso.")
            val intent = Intent(this, MainActivity::class.java).apply {
            }
            startActivity(intent)
        }
    }
}