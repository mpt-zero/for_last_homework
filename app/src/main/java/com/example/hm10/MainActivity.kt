package com.example.hm10

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.view_pager)

        val fragments : ArrayList<Fragment> = arrayListOf(
            Page1Fragment(),
            Page2Fragment()
         )

        val adapter = ViewPagerAdapter(fragments,this)
        viewPager.adapter = adapter
//
//        loadData()
//
//        btn.setOnClickListener {
//            saveData()
//
//        }

    }

//    private fun saveData(){
//
//        userName.text = name.text.toString()
//        userLastName.text = lastname.text.toString()
//        userEmail.text = email.text.toString()
//        sp = getSharedPreferences("MyUserPrefs",Context.MODE_PRIVATE)
//        val editor = sp.edit()
//        editor.apply{
//            putString("NAME",userName.text.toString())
//            putString("LASTNAME",userLastName.text.toString())
//            putString("EMAIL",userEmail.text.toString())
//        }.apply()
//
//        Toast.makeText(this,"Data Saved",Toast.LENGTH_SHORT).show()
//
//    }

//    private fun loadData(){
//        if(name.text.isNotEmpty()){
//            getName.text = sp.getString("NAME",null)
//        }else{
//            getName.text = "No Info Were Saved!"
//        }
//
//        if(lastname.text.isNotEmpty()){
//            getLastName.text = sp.getString("NAME",null)
//        }else{
//            getLastName.text = "No Info Were Saved!"
//        }
//
//        if(email.text.isNotEmpty()){
//            getEmail.text = sp.getString("NAME",null)
//        }else{
//            getEmail.text = "No Info Were Saved!"
//        }
//    }

//    override fun onBackPressed() {
//        if(viewPager.currentItem == 0)
//        super.onBackPressed()
//        else{
//            viewPager.currentItem = viewPager.currentItem - 1
//        }
//    }
}