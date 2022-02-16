package com.example.magicball

import android.animation.Animator
import android.annotation.SuppressLint
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

class MainActivity : AppCompatActivity() {

    private lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)


        bindingClass.imageView.setOnClickListener {
            bindingClass.answer.text = getArr()
            AnimationUtils.loadAnimation(this,R.anim.tv_animation)
        }



    }

    private fun viewAnimate(){
        ViewCompat.animate(bindingClass.answer)
            .translationX(50f)
            .translationY(100f)
            .setDuration(1000)
            .setInterpolator(AccelerateDecelerateInterpolator()).startDelay = 50

    }

    private fun getArr(): String{
        return resources.getStringArray(R.array.arr)[randomNumber()]
    }

    private fun randomNumber(): Int{
        val size = resources.getStringArray(R.array.arr).size - 1
        return(0..size).random()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mine_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){

            R.id.exit -> finish()
            R.id.sound_on ->{

            }
            R.id.language ->{

            }
        }
        return true
    }
}