package com.gds20052.mfusion

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AccelerateInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class Splash_screen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        var image = findViewById<ImageView>(R.id.image)

//     Method to call the animation

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(
            ObjectAnimator.ofFloat(image, "translationY", -1000f, 0f),
            ObjectAnimator.ofFloat(image, "alpha", 0f, 1f),
        )
         animatorSet.duration = 2000
        animatorSet.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                val animatorSet2 = AnimatorSet()
                animatorSet2.playTogether(
                    ObjectAnimator.ofFloat(image, "scaleX", 1f, 0.5f, 1f),
                    ObjectAnimator.ofFloat(image, "scaleY", 1f, 0.5f, 1f)
                )
                animatorSet2.interpolator = AccelerateInterpolator()
                animatorSet2.duration = 1000
                animatorSet2.start()
            }
        })
        animatorSet.start()

//        Method to call the another activity

        Handler().postDelayed(Runnable {
            val intenr = Intent(this@Splash_screen, MainActivity::class.java)
            startActivity(intenr)
            finish()
        }, 2000L)

        }
    }
