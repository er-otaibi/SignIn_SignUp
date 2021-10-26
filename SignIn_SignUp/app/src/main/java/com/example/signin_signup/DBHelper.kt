package com.example.signin_signup

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DBHelper(context: Context) : SQLiteOpenHelper(context, "Users.db", null, 1) {

    private var sqLiteDatabase: SQLiteDatabase = writableDatabase
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table user (Name text , Phone text , Location text , Password text )")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {}

    fun saveUser(s1: String ,s2: String,s3: String,s4: String ): Long {
        val cv = ContentValues()
        cv.put("Name", s1)
        cv.put("Phone", s2)
        cv.put("Location", s3)
        cv.put("Password", s4)
        return sqLiteDatabase.insert("user", null, cv)
    }

    @SuppressLint("Range")
    fun getUserInfo(note: String): String {

        var c : Cursor = sqLiteDatabase.query("user" , null , "Name=?" , arrayOf(note) , null , null , null)
        c.moveToFirst()


        var name = c.getString(c.getColumnIndex("Name"))
        var phone = c.getString(c.getColumnIndex("Phone"))
        var location = c.getString(c.getColumnIndex("Location"))

        return "Welcome $note\n\nYou Details are,\n\n Phone Number:  $phone\n Location:  $location\n"

    }


    @SuppressLint("Range")
    fun checkUser(name: String, password: String ): String {

        var c : Cursor = sqLiteDatabase.query("user" , null , "Name=?" , arrayOf(name) , null , null , null)
        c.moveToFirst()


        var pass = c.getString(c.getColumnIndex("Password"))
        var phone = c.getString(c.getColumnIndex("Phone"))
        var location = c.getString(c.getColumnIndex("Location"))

        return if (pass == password){
            "Welcome $name\n\nYou Details are,\n\n Phone Number:  $phone\n Location:  $location\n"
        }else {
            "Something went wrong!\nplease check your password"
        }

    }

    @SuppressLint("Range")
    fun readData() {
        var selectQuery = "SELECT  * FROM user"
        var cursor: Cursor? = null
        try {

            cursor = sqLiteDatabase.rawQuery(selectQuery, null)
        } catch (e: SQLiteException) {
            sqLiteDatabase.execSQL(selectQuery)
        }
        var note: String
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    note = cursor.getString(cursor.getColumnIndex("Note"))
                 //   MyList.notesList.add(note)
                } while (cursor.moveToNext())
            }
        }
    }


}