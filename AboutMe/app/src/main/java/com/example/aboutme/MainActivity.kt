package com.example.aboutme

import android.annotation.SuppressLint
import android.content.Context
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /* Creating a variable for the automatically generated binding object */
    private lateinit var binding: ActivityMainBinding

    /* create an instance of MyName to update the name and nickname */
    private val myName: MyName = MyName("Tamir Omara")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
        *   1. Inflate the binding object using data binding class DataBindingUtil
        *   2. Connect the view to the layout
        */
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // set binding.myName to it:
        binding.myName = myName

        /*
        *   1. Use the binding object to access the desired view
        *   2. setOnClickListener on the desired view
        *  */
        binding.doneButton.setOnClickListener { addNick(it) }

    }

    private fun addNick(view: View) {
        binding.apply {
            nicknameText.text = binding.nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard once
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}

