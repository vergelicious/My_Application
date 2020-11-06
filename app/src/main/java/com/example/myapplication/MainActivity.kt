package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            val username = findViewById<EditText>(R.id.txtUsername)
            val password = findViewById<EditText>(R.id.txtPassword)

            if (username.equals("admin") && password.equals("1234")) {
                Application()
            } else {
                Toast.makeText(this, "Incorrect username or password.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

private fun login() {
    val intent = Intent( this, Application::class.java )
    startActivity(intent)
    Toast.makeText(this, "You are now logged in.", Toast.LENGTH_SHORT).show()
}
