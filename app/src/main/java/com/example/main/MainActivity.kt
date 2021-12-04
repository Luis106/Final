package com.example.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    internal lateinit var eTxtUser: EditText
    internal lateinit var eTxtPass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        eTxtUser=findViewById(R.id.eTxtUser)
        eTxtPass=findViewById(R.id.eTxtPass)

        val btnLogin: Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            if (eTxtUser.getText().toString().equals("user") && eTxtPass.getText().toString().equals("user")) {
                Log.d("Button", "Logeado.")
                val intent = Intent(this, AdminMain::class.java).apply {
                }
                startActivity(intent)
            }else if(eTxtUser.getText().toString().equals("user001") && eTxtPass.getText().toString().equals("user")){
                val intent = Intent(this, UserMain::class.java).apply {
                }
                startActivity(intent)
            }else{
                Toast.makeText(this, "Usuario o contraseña incorrecto.", Toast.LENGTH_LONG).show()
            }
        }

        //val btnExit: Button = findViewById(R.id.btnExit)
        //btnExit.setOnClickListener {
               // Log.d("Button", "¡Buen día!.")
              //  System.runFinalization()
      //  }
    }
}