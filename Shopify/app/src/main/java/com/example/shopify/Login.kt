package com.example.shopify


import android.content.Intent
import android.os.Bundle
import android.util.Log

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var password = findViewById<EditText>(R.id.txtPwd);
        var email = findViewById<EditText>(R.id.txtEmail);
        val btnDisplay = findViewById<Button>(R.id.btnLogin)
        btnDisplay.setOnClickListener(){
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }

    }
}