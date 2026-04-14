package com.example.group2app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ✅ NAV BUTTONS
        val navHome = findViewById<Button>(R.id.navHome)
        val navQuote = findViewById<Button>(R.id.navQuote)
        val navContact = findViewById<Button>(R.id.navContact)
        val navCourses = findViewById<Button>(R.id.navCourses)

        // ✅ HOME (reloads current page)
        navHome.setOnClickListener {
            // already on home, so just refresh
            startActivity(Intent(this, MainActivity::class.java))
        }


        // ✅ GO TO QUOTE PAGE
        navQuote.setOnClickListener {
            val intent = Intent(this, QuoteActivity::class.java)
            startActivity(intent)
        }

        // ✅ GO TO CONTACT PAGE
        navContact.setOnClickListener {
            val intent = Intent(this, ContactActivity::class.java)
            startActivity(intent)
        }

        // ✅ GO TO COURSES PAGE
        navCourses.setOnClickListener {
            val intent = Intent(this, CoursesActivity::class.java)
            startActivity(intent)
        }
    }
}