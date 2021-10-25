package com.example.androidkotlintutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_other.*
import kotlin.random.Random

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        val choiceTexts =
            arrayListOf<String>("Jabba", "Vader", "Palpatine", "Kylo", "Medal", "Climate change")

            Toast.makeText(this@OtherActivity,"yo", Toast.LENGTH_LONG)
            buttonGoFish2.setOnClickListener {

                //val rnds:Int = (0..(choiceTexts.size-1)).random()   //achives the same with range
                var rnds = Random.Default.nextInt(choiceTexts.count()) //achives the same with nextInt, which i assume use less resources or something
                Toast.makeText(this@OtherActivity,"yo", Toast.LENGTH_LONG)
                textView2.text = choiceTexts[rnds]

            }
            buttonAdd2.setOnClickListener {
                var str: String = inputField2.text.toString() ?: "";

                if(str != R.string.input_text_hint2.toString() && str!= "") {
                    choiceTexts.add(str)
                    Toast.makeText(this@OtherActivity,str+" was added as an alternative", Toast.LENGTH_LONG)
                }

            }
            buttonGoMain.setOnClickListener{
                val intent = Intent(this@OtherActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            /*if(choiceTexts[6]!=null) {// didn't work, ask majid about nullables
                    val rnds: Int =
                        (0..6).random()                  // I intentionally set this to go too high
                    textView.text = choiceTexts[rnds] ?: "Oh shit it's på norsk"*/
        }



    }
