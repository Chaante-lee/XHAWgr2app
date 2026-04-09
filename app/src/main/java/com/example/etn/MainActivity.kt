package com.example.etn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Initialize the Drawer and Menu Icon
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val hamburgerMenu = findViewById<ImageView>(R.id.hamburger_menu)
        val navView = findViewById<NavigationView>(R.id.nav_view)

        // 2. Open Drawer when Hamburger is clicked
        hamburgerMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        // 3. Handle Side Menu Item Clicks
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Already on Home
                }
                R.id.nav_courses -> {
                    startActivity(Intent(this, CoursesActivity::class.java))
                }
                R.id.nav_quote -> {
                    // Matching your nav_menu.xml ID for Fee Calculator
                    startActivity(Intent(this, FeesActivity::class.java))
                }
                R.id.nav_contact -> {
                    startActivity(Intent(this, ContactActivity::class.java))
                }
            }
            // Close the drawer after a click
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // 4. Main Home Page Button
        findViewById<Button>(R.id.viewCoursesBtn).setOnClickListener {
            startActivity(Intent(this, CoursesActivity::class.java))
        }
    }

    //  Close drawer if "Back" is pressed instead of closing the app
    override fun onBackPressed() {
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}