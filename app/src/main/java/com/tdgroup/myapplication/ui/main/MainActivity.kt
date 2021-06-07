package com.tdgroup.myapplication.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tdgroup.myapplication.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        navView.menu.clear() //clear old inflated items.

        navView.inflateMenu(R.menu.bottom_nav_menu)
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        navController.setGraph(R.navigation.mobile_navigation)


        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_dashboard, R.id.navigation_home, R.id.navigation_notifications
        )
            .build()

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(navView, navController)
    }
}