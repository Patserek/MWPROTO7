package com.example.mwproto1.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.mwproto1.R

import kotlinx.android.synthetic.main.activity_dzienniczek.*

class Dzienniczek : AppCompatActivity() {

    private lateinit var navController: NavController



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dzienniczek)
        setSupportActionBar(toolbar)

        navController=Navigation.findNavController(this,
            R.id.fragment
        )
        NavigationUI.setupActionBarWithNavController(this,navController)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,null)
    }

}
