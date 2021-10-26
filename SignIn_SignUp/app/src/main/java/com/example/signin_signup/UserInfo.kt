package com.example.signin_signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class UserInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        title ="Your Profile"

        var text1 = findViewById<TextView>(R.id.myText)
        var signOut = findViewById<Button>(R.id.signOut)
        var helper = DBHelper(applicationContext)
        val intent = intent

        if (intent.getStringExtra("name")?.isNotEmpty() == true){
            val name = intent.getStringExtra("name").toString()
            var r = helper.getUserInfo(name)
            text1.text = r
        }else{
            val name1 = intent.getStringExtra("name1").toString()
            val pass = intent.getStringExtra("pass").toString()
            var s = helper.checkUser(name1,pass)
            text1.text = s
        }

        signOut.setOnClickListener { this.finishAffinity() }

    }
}