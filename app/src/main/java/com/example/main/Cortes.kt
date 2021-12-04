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

class Cortes : AppCompatActivity() {
    private lateinit var cortesListView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cortes)
        cortesListView=findViewById(R.id.listViewWebService)

        val url = "https://gist.githubusercontent.com/Luis106/a01dd3b007377a35b628128f5641978b/raw/0e3a6a032c34b8911bbd0ecb85a8c1345058202c/cortes.json"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(
            Request.Method.GET, url, Response.Listener { response ->
                Log.d("response","La respuesta es ${response}")

                val cortesList = Gson().fromJson(response, CortesInfo::class.java).cortes
                Log.d("name", "${cortesList[0].fecha}")

                val adapter = CortesAdapter(this, cortesList)
                cortesListView.adapter=adapter
            },
            Response.ErrorListener {
                Log.d("response","Ha ocurrido un error.")
            })
        queue.add(stringRequest)
    }
}