package com.naca.loafavor.ui.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import com.naca.loafavor.R
import com.naca.loafavor.databinding.AppMainBinding

class AppMain : AppCompatActivity() {

    private lateinit var binding : AppMainBinding
    private lateinit var sideList: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        var toolbar = binding.toolbarAction
        toolbar.setTitleTextColor(Color.BLACK)

        sideList = binding.drawerLayout

        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                sideList.openDrawer(GravityCompat.START)
                return true
            }
            R.id.list_collection -> {
                Toast.makeText(this.applicationContext, "collection list", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onBackPressed() {
        if (sideList.isDrawerOpen(GravityCompat.START)) {
            sideList.closeDrawers()
        } else {
            super.onBackPressed()
        }
    }
}