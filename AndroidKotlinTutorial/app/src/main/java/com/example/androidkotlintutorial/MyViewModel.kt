package com.example.androidkotlintutorial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MyViewModel : ViewModel(){
    val choiceTexts : MutableLiveData<ArrayList<String>> by lazy {
        MutableLiveData<ArrayList<String>>()
    }
    val currentText : MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }

    fun setText(){
        val rnds =
            choiceTexts.value?.count()?.let { Random.Default.nextInt(it) } //achives the same with nextInt, which i assume use less resources or something
        if (rnds!= null){
            this.currentText.value = choiceTexts.value?.get(rnds)
        }
    }

}