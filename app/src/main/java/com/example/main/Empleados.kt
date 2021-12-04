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

class Empleados : AppCompatActivity() {
    private lateinit var empleadosListView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empleados)
        empleadosListView=findViewById(R.id.listViewWebService)

        val url = "https://gist.githubusercontent.com/Luis106/59244b937c06f8e7635c5283f545c17c/raw/0ab1f79c20c3b65c94c234aa102fb5c978f3bfbd/gistfile1.txt"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(
            Request.Method.GET, url, Response.Listener { response ->
                Log.d("response","La respuesta es ${response}")

                val empleadosList = Gson().fromJson(response, EmpleadosInfo::class.java).empleados
                Log.d("name", "${empleadosList[0].name}")

                val adapter = EmpleadosAdapter(this, empleadosList)
                empleadosListView.adapter=adapter
            },
            Response.ErrorListener {
                Log.d("response","Ha ocurrido un error.")
            })
        queue.add(stringRequest)
    }
}