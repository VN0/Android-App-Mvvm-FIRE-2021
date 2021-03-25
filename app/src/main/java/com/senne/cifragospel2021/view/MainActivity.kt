package com.senne.cifragospel2021.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.google.firebase.firestore.FirebaseFirestore
import com.senne.cifragospel2021.R


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_search, R.id.nav_all, R.id.nav_myList), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val db = FirebaseFirestore.getInstance()



    }


    private fun generateSimple(txt: String, keywords: MutableList<String>) {

        var inputString = txt
        val words = inputString.split(" ")
        for(word in words) {
            var appendString = ""
            for(charPosition in inputString.indices) {
                appendString += inputString[charPosition].toString().replace("á","a").replace("ã","a")
                    .replace("â","a").replace("é","e").replace("ê","e")
                    .replace("í","i").replace("ó","o").replace("ô","o").replace("ú","u")
                if(appendString.length > 3) {
                    keywords.add(appendString.toLowerCase())
                }

            }
            inputString = inputString.replace("$word ", "")
        }
    }
    private fun generateSearchKeyWords(inputText: String): List<String> {

        var keyWords = mutableListOf<String>()
        generateSimple(inputText, keyWords)

        return keyWords
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}