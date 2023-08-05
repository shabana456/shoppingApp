package com.example.shopify


import android.content.Intent
import android.os.Bundle
import android.util.Log

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity

class Dashboard : AppCompatActivity() {
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val btnDisplay = findViewById<Button>(R.id.btnPayment)
        btnDisplay.setOnClickListener(){
            val intent = Intent(this, Payment::class.java)
            startActivity(intent)
        }
    }
}