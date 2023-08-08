package com.example.shopify


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast


class Dashboard : AppCompatActivity(){

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val btFragmentOne = findViewById<Button>(R.id.frament1btn)
        val btFragmentTwo = findViewById<Button>(R.id.frament2btn)
        val btFragmentThree = findViewById<Button>(R.id.frament3btn)
        //btnfrag1Display.setOnClickListener(this)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, KFragment.newInstance("", ""))
            commit()
            addToBackStack(null)
        }
        btFragmentOne.setOnClickListener{
            supportFragmentManager.beginTransaction().
            apply {
                replace(R.id.frameLayout,MFragment.newInstance("",""))
                commit()
                addToBackStack(null)
            }
        }

        btFragmentTwo.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout,WFragment.newInstance("",""))
                commit()
                addToBackStack(null)
            }
        }
        btFragmentThree.setOnClickListener{
            supportFragmentManager.beginTransaction().
            apply {
                replace(R.id.frameLayout,KFragment.newInstance("",""))
                commit()
                addToBackStack(null)
            }
        }
    }


}