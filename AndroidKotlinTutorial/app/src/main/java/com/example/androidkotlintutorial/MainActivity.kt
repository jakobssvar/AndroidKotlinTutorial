package com.example.androidkotlintutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    val choiceTexts =
        arrayListOf<String>("Han Solo", "Leia", "luke", "Rey", "Chewbacca", "Bill Nye")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this@MainActivity,"yo",Toast.LENGTH_LONG)
        buttonGoFish.setOnClickListener {

            //val rnds:Int = (0..(choiceTexts.size-1)).random()   //achives the same with range
            var rnds = Random.Default.nextInt(choiceTexts.count()) //achives the same with nextInt, which i assume use less resources or something
            Toast.makeText(this@MainActivity,"yo",Toast.LENGTH_LONG)
            textView.text = choiceTexts[rnds]

        }
        buttonAdd.setOnClickListener {
            var str: String = inputField.text.toString() ?: "";

            if(str != R.string.input_text_hint.toString() && str!= "") {
                choiceTexts.add(str)
                Toast.makeText(this@MainActivity,str+" was added as an alternative",Toast.LENGTH_LONG)
            }

        }
        buttonGoOther.setOnClickListener{
            val intent = Intent(this@MainActivity, OtherActivity::class.java)
            startActivity(intent)
        }
        buttonGoFragment.setOnClickListener{
            val intent = Intent(this@MainActivity, FragmentedActivity::class.java)
            startActivity(intent)
        }
        /*if(choiceTexts[6]!=null) {// didn't work, ask majid about nullables
                val rnds: Int =
                    (0..6).random()                  // I intentionally set this to go too high
                textView.text = choiceTexts[rnds] ?: "Oh shit it's på norsk"*/
    }

    //R.string.text_view_text //resources.string.*name*       xml: @string/*name*


}

