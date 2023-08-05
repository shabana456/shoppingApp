package com.example.shopify
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("aTAG","MainActivity-onRestart")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDisplay = findViewById<Button>(R.id.btDisplayInView)
        btnDisplay.setOnClickListener(){
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
        val btnLoginDisplay = findViewById<Button>(R.id.btLoginInView)
        btnLoginDisplay.setOnClickListener(){
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}