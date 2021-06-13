package com.senne.cifragospel2021.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.senne.cifragospel2021.R
import com.senne.cifragospel2021.sharedPreferences.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*
import kotlin.random.Random

class SplashActivity : AppCompatActivity() {

    private lateinit var securityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if (supportActionBar != null) supportActionBar!!.hide()

        //Animation
        val animations = AnimationUtils.loadAnimation(this, R.anim.top_anim)
        splash_progress.startAnimation(animations)

        securityPreferences = SecurityPreferences(this)

        var email = securityPreferences.getString("email")
        if (email != "") {
            startTela(2000)

        } else {
            val n1 = Random.nextInt(0, 3500)
            val n2 = Random.nextInt(0, 3500)
            val n3 = Random.nextInt(0, 3500)
            val n4 = Random.nextInt(0, 3500)
            securityPreferences.storeString("email", "$n1 $n2 $n3 $n4")


            startTela(2000)
        }

    }

    private fun startTela(time: Long) {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, time)

    }
}