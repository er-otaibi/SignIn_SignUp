package com.example.signin_signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        title = "Sign In"

        var etName = findViewById<EditText>(R.id.etname)
        var etPassword = findViewById<EditText>(R.id.etpassword)
        var submit = findViewById<Button>(R.id.submit1)

        submit.setOnClickListener {

            var helper = DBHelper(applicationContext)

            var name = etName.text.toString()
            var password = etPassword.text.toString()

            val intent = Intent(this, UserInfo::class.java)
            intent.putExtra("name1", name )
            intent.putExtra("pass", password )
            startActivity(intent)
        }
    }
}