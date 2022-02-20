package com.example.magicball

import android.content.Context
import android.os.Vibrator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.magicball.databinding.ActivityMainBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

open class MainActivity : AppCompatActivity() {

    private lateinit var bindingClass: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        unitAdMob()
        (application as AppMainState).showAdIfAvailable(this){}

        //ball
        bindingClass.imageBall.setOnClickListener{
            bindingClass.answer.text = getArr()

           val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

           val animBall= AnimationUtils.loadAnimation(this, R.anim.anim_ball)
           val animAnswer= AnimationUtils.loadAnimation(this, R.anim.anim_answer)

           vibratorService.vibrate(600)
           bindingClass.imageBall.startAnimation(animBall)
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
    }

    override fun onResume() {
        super.onResume()
        bindingClass.adView.resume()
    }

    override fun onPause() {
        super.onPause()
        bindingClass.adView.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        bindingClass.adView.destroy()
    }




    private fun getArr(): String{
        return resources.getStringArray(R.array.arr)[randomNumber()]
    }

    private fun randomNumber(): Int{
        val size = resources.getStringArray(R.array.arr).size - 1
        return(0..size).random()
    }

    private fun unitAdMob(){
        MobileAds.initialize(this)
        val adRequest = AdRequest.Builder().build()
        bindingClass.adView.loadAd(adRequest)
    }


}