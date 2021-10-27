package com.example.androidkotlintutorial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MyViewModel : ViewModel(){
    var choiceTexts : ArrayList<String> = ArrayList<String>()
    val currentText : MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }

    fun setText(){
        val rnds = Random.Default.nextInt(choiceTexts.count()) //achives the same with nextInt, which i assume use less resources or something
        this.currentText.value = choiceTexts[rnds]
    }

}