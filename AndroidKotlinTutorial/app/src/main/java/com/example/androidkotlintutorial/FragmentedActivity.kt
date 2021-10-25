package com.example.androidkotlintutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FragmentedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmented)
    }
    public fun goMain(){
        val intent = Intent(this@FragmentedActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    public fun goOther(){
        val intent = Intent(this@FragmentedActivity, OtherActivity::class.java)
        startActivity(intent)
        finish()
    }
}