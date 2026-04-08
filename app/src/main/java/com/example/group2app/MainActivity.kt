package com.example.group2app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHome = findViewById<TextView>(R.id.navHome)
        val navCourses = findViewById<TextView>(R.id.navCourses)
        val navQuote = findViewById<TextView>(R.id.navQuote)
        val navContact = findViewById<TextView>(R.id.navContact)
        val btnQuote = findViewById<Button>(R.id.btnQuote)

        // Navigation clicks
        navHome.setOnClickListener {
            // Already on home
        }

        navCourses.setOnClickListener {
            startActivity(Intent(this, CoursesActivity::class.java))
        }

        navQuote.setOnClickListener {
            startActivity(Intent(this, QuoteActivity::class.java))
        }

        navContact.setOnClickListener {
            startActivity(Intent(this, ContactActivity::class.java))
        }

        btnQuote.setOnClickListener {
            startActivity(Intent(this, QuoteActivity::class.java))
        }
    }
}