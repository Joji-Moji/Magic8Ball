package com.example.magicball

import android.animation.Animator
import android.annotation.SuppressLint
import android.app.SearchManager
import android.graphics.Color.red
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.core.view.ViewCompat
import com.example.magicball.databinding.ActivityMainBinding

open class MainActivity : AppCompatActivity() {

    private lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        //ball
        bindingClass.imageView.setOnClickListener {
            bindingClass.answer.text = getArr()
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