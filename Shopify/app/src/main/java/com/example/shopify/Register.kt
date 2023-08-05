package com.example.shopify


import android.content.Intent
import android.os.Bundle
import android.util.Log

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity

class Register : AppCompatActivity() {
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        var name=findViewById<EditText>(R.id.txtName);
        var password = findViewById<EditText>(R.id.txtPwd);
        var email = findViewById<EditText>(R.id.txtEmai);
        var phoneno= findViewById<EditText>(R.id.txtPhone);
        var result = findViewById<TextView>(R.id.resultView);
        val btnDisplay = findViewById<Button>(R.id.btnRegister)
        btnDisplay.setOnClickListener(){
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }

    }
}