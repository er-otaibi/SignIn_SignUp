package com.example.signin_signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var signIn = findViewById<Button>(R.id.signIn)
        var signUp = findViewById<Button>(R.id.signUp)

        signIn.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent) }

        signUp.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }
}