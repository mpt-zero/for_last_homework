package com.example.hm10

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Page2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Page2Fragment() : Fragment() {
    lateinit var name : EditText
    lateinit var email : EditText
    lateinit var lastname : EditText
    lateinit var image : EditText
    lateinit var imageview : ImageView
    lateinit var btn : Button
    lateinit var sp : SharedPreferences
    lateinit var editor : SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sp = context?.getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE)!!


        editor = sp.edit()

        name = view.findViewById(R.id.editName)
        email = view.findViewById(R.id.editEmail)
        lastname = view.findViewById(R.id.editLastName)
        btn = view.findViewById(R.id.button)
        image = view.findViewById(R.id.imageEdit)
        imageview = view.findViewById(R.id.imageView)


        btn.setOnClickListener {
            saveData()
        }

    }

        private fun saveData(){

        editor.apply{
            putString("NAME",name.text.toString())
            putString("LASTNAME",lastname.text.toString())
            putString("EMAIL",email.text.toString())
            putString("IMAGE",image.text.toString())
        }.apply()
            Glide.with(this)
                .load(image.text.toString())
                .centerCrop()
                .into(imageview)



        Toast.makeText(context,"Data Saved",Toast.LENGTH_SHORT).show()

    }


}