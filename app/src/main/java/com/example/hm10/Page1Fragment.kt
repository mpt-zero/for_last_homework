package com.example.hm10

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class Page1Fragment : Fragment()  {
    lateinit var sp : SharedPreferences
    lateinit var getName : TextView
    lateinit var getLastName : TextView
    lateinit var getEmail : TextView
    lateinit var imageProfile : ImageView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getName = view.findViewById(R.id.showName)
        getLastName = view.findViewById(R.id.showLastName)
        getEmail = view.findViewById(R.id.showEmail)
        imageProfile = view.findViewById(R.id.imageProfile)

        sp = context?.getSharedPreferences("MyUserPrefs",Context.MODE_PRIVATE)!!

        loadData()
    }



    private fun loadData(){

        if(sp.contains("NAME")){
            getName.text = sp.getString("NAME","No Info Were Saved!")
        }else{
            getName.text = "No Info Were Saved!"
        }

        if(sp.contains("LASTNAME")){
            getLastName.text = sp.getString("LASTNAME","No Info Were Saved!")
        }else{
            getLastName.text = "No Info Were Saved!"
        }

        if(sp.contains("EMAIL")){
            getEmail.text = sp.getString("EMAIL","No Info Were Saved!")
        }

        if(sp.contains("IMAGE")){
            Glide.with(this)
                .load(sp.getString("IMAGE",""))
                .centerCrop()
                .into(imageProfile)
        }
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }


}