package com.example.androidkotlintutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    var choiceTexts: ArrayList<String> =
        arrayListOf<String>("Han Solo", "Leia", "luke", "Rey", "Chewbacca", "Bill Nye")
    lateinit var viewModel : MyViewModel

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList("listMain", choiceTexts)
        Log.d("debug", "savestate has been called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        choiceTexts = (savedInstanceState.getStringArrayList("listMain") as ArrayList<String>)
        Log.d("debug", "loadstate has been called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState!=null) {                                  //for some reason this is always null
            choiceTexts = (savedInstanceState.getStringArrayList("listMain") as ArrayList<String>)
                ?: arrayListOf<String>("Han Solo", "Leia", "luke", "Rey", "Chewbacca", "Bill Nye")
        }
        setContentView(R.layout.activity_main)
                                                                        //so let's try this instead
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        if( viewModel.choiceTexts.value==null || viewModel.choiceTexts.value?.count()==0){
            viewModel.choiceTexts.value = choiceTexts
        }
        viewModel.currentText.observe(this, Observer{textView.text = it.toString()})


        Toast.makeText(this@MainActivity,"yo",Toast.LENGTH_LONG)
        buttonGoFish.setOnClickListener {
            viewModel.setText()                 //it's not really right to use an observer for this but it's just training
        }
        buttonAdd.setOnClickListener {
            var str: String = inputField.text.toString() ?: "";

            if(str != R.string.input_text_hint.toString() && str!= "") {
                viewModel.choiceTexts.value?.add(str)

            }

        }
        buttonGoOther.setOnClickListener{
            val intent = Intent(this@MainActivity, OtherActivity::class.java)
            startActivity(intent)
            //finish()
        }
        buttonGoFragment.setOnClickListener{
            val intent = Intent(this@MainActivity, FragmentedActivity::class.java)
            startActivity(intent)
            //finish()
        }
        /*if(choiceTexts[6]!=null) {// didn't work, ask majid about nullables
                val rnds: Int =
                    (0..6).random()                  // I intentionally set this to go too high
                textView.text = choiceTexts[rnds] ?: "Oh shit it's på norsk"*/
    }

    override fun onDestroy() {

        super.onDestroy()


    }

    //R.string.text_view_text //resources.string.*name*       xml: @string/*name*


}

