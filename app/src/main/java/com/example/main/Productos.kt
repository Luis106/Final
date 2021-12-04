package com.example.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class Productos : AppCompatActivity() {
    private lateinit var productosListView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)
        productosListView=findViewById(R.id.listViewWebService)

        val url = "https://gist.githubusercontent.com/Luis106/2d40945fb658acc2f85c56ce13944d6e/raw/4accba28ca048100af82ec7a3bb86ec041783a66/productoInfoArray.json"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(
            Request.Method.GET, url, Response.Listener { response ->
                Log.d("response","La respuesta es ${response}")

                val productosList = Gson().fromJson(response, ProductosInfo::class.java).productos
                Log.d("name", "${productosList[0].name}")

                val adapter = ProductosAdapter(this, productosList)
                productosListView.adapter=adapter
            },
            Response.ErrorListener {
                Log.d("response","Ha ocurrido un error.")
            })
        queue.add(stringRequest)
    }
}