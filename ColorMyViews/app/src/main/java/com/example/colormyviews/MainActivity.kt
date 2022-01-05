package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.colormyviews.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View>
        // Because we're setting the same clickListener on each view, we use a listOf views
        binding.apply {
            clickableViews = listOf(
                boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, constraintLayout,
                redButton, greenButton, yellowButton)
        }
        // setting the listener for each view
        clickableViews.forEach {
                view -> view.setOnClickListener {
            makeColored(it)
                }
        }
    }

    private fun makeColored(view: View) {
        // accessing the resource id of the views
        when (view.id) {

            /*
             *       Boxes using Color class colors for background.
             */
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            /*
             *       Boxes using Android color resources for background
             */
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_dark)

            R.id.red_button -> binding.boxThreeText.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> binding.boxFourText.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> binding.boxFiveText.setBackgroundResource(R.color.my_green)


            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}