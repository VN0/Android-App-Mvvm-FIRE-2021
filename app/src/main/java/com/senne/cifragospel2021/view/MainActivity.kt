package com.senne.cifragospel2021.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.Source
import com.senne.cifragospel2021.R
import com.senne.cifragospel2021.model.AllModel
import com.senne.cifragospel2021.model.SearchModel
import com.senne.cifragospel2021.sharedPreferences.SecurityPreferences

class MainActivity : AppCompatActivity(), DrawerLayout.DrawerListener {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        drawerLayout.setDrawerListener(this)

        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_search, R.id.nav_all, R.id.nav_myList), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

       // val db = FirebaseFirestore.getInstance()




    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onDrawerStateChanged(newState: Int) { }
    override fun onDrawerClosed(drawerView: View) { }
    override fun onDrawerOpened(drawerView: View) { }

    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
        closeKeyboard(drawerView)
    }

    private fun closeKeyboard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun loading(result: QuerySnapshot) {
        val list = mutableListOf<AllModel>()
        for(document in result) {
            val cifra = document.toObject(AllModel::class.java)
            list.add( AllModel("${cifra.banda}","${cifra.foto}") )
        }
    }
}