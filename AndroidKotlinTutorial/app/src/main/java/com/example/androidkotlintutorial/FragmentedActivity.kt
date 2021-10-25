package com.example.androidkotlintutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fragmented.*

class FragmentedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmented)

        buttonFrag1.setOnClickListener{
           val transaction = supportFragmentManager.beginTransaction()
           transaction.replace(R.id.fragmentContainerView, FragmentMain())
           transaction.commit()
        }

        buttonFrag2.setOnClickListener{
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, FragmentOther())
            transaction.commit()
        }
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