package com.example.a12_animacions

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.a12_animacions.databinding.ActivitySplash2Binding

class SplashStartActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplash2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplash2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val animacio = AnimationUtils.loadAnimation(this, R.anim.animation)
        binding.splashLogo.startAnimation(animacio)

        animacio.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation) {
                binding.splashLogo.setOnClickListener {
                    val intent = Intent(this@SplashStartActivity, MainActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                }
                binding.splashLogo.clearAnimation()

            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
    }
}



