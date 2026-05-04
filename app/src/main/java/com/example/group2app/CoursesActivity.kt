package com.example.group2app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CoursesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        // NAVIGATION BUTTONS
        val navHome = findViewById<Button>(R.id.navHome)
        val navQuote = findViewById<Button>(R.id.navQuote)
        val navContact = findViewById<Button>(R.id.navContact)

        navHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        navQuote.setOnClickListener {
            startActivity(Intent(this, QuoteActivity::class.java))
            finish()
        }

        navContact.setOnClickListener {
            startActivity(Intent(this, ContactActivity::class.java))
        }

        // COURSE NAVIGATION BUTTONS
        val btn6WeekCourses = findViewById<Button>(R.id.navCourses6Week)
        val btn6MonthCourses = findViewById<Button>(R.id.navCourses6Month)

        btn6WeekCourses.setOnClickListener {
            startActivity(Intent(this, WeekscoursesActivity::class.java))
        }

        btn6MonthCourses.setOnClickListener {
            startActivity(Intent(this, MonthscoursesActivity::class.java))
        }
    }
}