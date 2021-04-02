package com.senne.cifragospel2021.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.senne.cifragospel2021.R
import com.senne.cifragospel2021.sharedPreferences.SecurityPreferences
import kotlinx.coroutines.Job
import kotlin.random.Random

class SplashActivity : AppCompatActivity() {

    private lateinit var securityPreferences : SecurityPreferences
    private var searchJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if(supportActionBar != null) supportActionBar!!.hide()

        securityPreferences = SecurityPreferences(this)

        var email = securityPreferences.getString("email")
        if(email != "") {
            startTela()
        }else {
            val n1 =  Random.nextInt(0, 3500)
            val n2 =  Random.nextInt(0, 3500)
            val n3 =  Random.nextInt(0, 3500)
            val n4 =  Random.nextInt(0, 3500)

            securityPreferences.storeString("email","$n1 $n2 $n3 $n4")

            Handler(Looper.getMainLooper()).postDelayed({
                startTela()
            }, 3000)
        }

    }

    private fun startTela() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}