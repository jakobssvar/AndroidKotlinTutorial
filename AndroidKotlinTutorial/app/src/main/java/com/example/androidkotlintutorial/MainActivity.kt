package com.example.androidkotlintutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Scene
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val choiceTexts = arrayListOf<String>("Han Solo","Leia","luke","Rey","Chewbacca","Bill Nye")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonGoFish.setOnClickListener {

            val rnds:Int = (0..(choiceTexts.size-1)).random()
            textView.text =  choiceTexts[rnds]

            /* didn't work, ask majid about nullables
            val rnds:Int = (0..6).random()                  // I intentionally set this to go too high
            textView.text =  choiceTexts[rnds] ?: "Oh shit it's på norsk"
            */

            //R.string.text_view_text //resources.string.*name*       xml: @string/*name*


        }
    }

}