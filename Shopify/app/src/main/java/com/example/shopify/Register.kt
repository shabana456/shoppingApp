package com.example.shopify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.shopify.Bean.UserLogin
import com.example.shopify.DB.LoginDBAdapter
import android.view.View
import com.example.shopify.databinding.ActivityRegisterBinding


class Register : AppCompatActivity() {
    private val activity = this@Register
    private lateinit var loginDBAdapter:LoginDBAdapter
    private lateinit var mBinding : ActivityRegisterBinding;
    var errorFlag = false;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       mBinding = ActivityRegisterBinding.inflate(LayoutInflater.from(this));
       setContentView(mBinding.root)
        var name = findViewById<EditText>(R.id.txtName);
        var password = findViewById<EditText>(R.id.txtPwd);
        var email = findViewById<EditText>(R.id.txtEmai);
        var phoneno = findViewById<EditText>(R.id.txtPhone);
        var result = findViewById<TextView>(R.id.resultView);
        val btnDisplay = findViewById<Button>(R.id.btnRegister);
        var errorMessage: String? = null
        loginDBAdapter = LoginDBAdapter(activity)
        btnDisplay.setOnClickListener() {
            if(name.text.toString().isNotBlank() && name.text.toString().isNotEmpty()) {
                addNewUser(name, password)
                val intent = Intent(this, Dashboard::class.java)
                startActivity(intent)
            }else{
                errorMessage = "Full Name is required."
                 mBinding.txtName.apply {
                 error =errorMessage
             }
           }

        }
    }

    private fun addNewUser(etUsername: EditText?, etPassword: EditText?) {
        var check : Int = -1

        if (etUsername != null) {
            if (etPassword != null) {
                if (etUsername.text.toString().isEmpty() || etPassword.text.toString().isEmpty()) {
                    Toast.makeText(applicationContext,
                        "Username/Password empty", Toast.LENGTH_SHORT).show()
                } else {
                    if (etUsername != null) {
                        println(etUsername.text.toString())
                    }
                    if (etPassword != null) {
                        println(etPassword.text.toString())
                    }
                    var user = UserLogin(
                        username = etUsername!!.text.toString().trim(),
                        password = etPassword!!.text.toString().trim()
                    )

                    check = loginDBAdapter.insertUser(user)
                }
            }
        }
        if (check != -1) {
            Toast.makeText(applicationContext, "Successfully Inserted", Toast.LENGTH_SHORT).show()
            if (etUsername != null) {
                etUsername.setText("")
            }
            if (etPassword != null) {
                etPassword.setText("")
            }
            //etUsername.hint = "username"
            if (etUsername != null) {
                etUsername.requestFocus()
            }
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(etUsername, InputMethodManager.SHOW_IMPLICIT)
        }
    }


}