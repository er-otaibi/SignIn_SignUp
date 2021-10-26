package com.example.signin_signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        title = "Sign Up"

        var etName = findViewById<EditText>(R.id.etName)
        var etPhone = findViewById<EditText>(R.id.etPhone)
        var etLocation = findViewById<EditText>(R.id.etLocation)
        var etPassword = findViewById<EditText>(R.id.etPassword)
        var submit = findViewById<Button>(R.id.submit)


        submit.setOnClickListener {
            var helper = DBHelper(applicationContext)
            var name = etName.text.toString()
            var phone = etPhone.text.toString()
            var location = etLocation.text.toString()
            var password = etPassword.text.toString()
            helper.saveUser(name,phone,location,password)

            Toast.makeText(this, "User added" , Toast.LENGTH_SHORT).show()

            val intent = Intent(this, UserInfo::class.java)
            intent.putExtra("name", name )
            startActivity(intent)
        }
    }


}