package com.example.magicball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.magicball.databinding.ActivityMainBinding

open class MainActivity : AppCompatActivity() {

    private lateinit var bindingClass: ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        //ball
        bindingClass.imageView.setOnClickListener{

            val animAnswer= AnimationUtils.loadAnimation(this, R.anim.anim_answer)
            bindingClass.answer.text = getArr()
            bindingClass.answer.startAnimation(animAnswer)
        }
        //exit
        bindingClass.buttonExit.setOnClickListener {
            finish()
        }
        //language
        bindingClass.buttonLang.setOnClickListener {

        }
        //sound


        bindingClass.buttonSound.setOnClickListener{
        }
    }


    private fun getArr(): String{
        return resources.getStringArray(R.array.arr)[randomNumber()]
    }

    private fun randomNumber(): Int{
        val size = resources.getStringArray(R.array.arr).size - 1
        return(0..size).random()
    }


}