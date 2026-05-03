package com.example.group2app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView

class MonthscoursesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monthscourses)

        // ===== NAVIGATION =====
        val navHome = findViewById<Button>(R.id.navHome)
        val navQuote = findViewById<Button>(R.id.navQuote)
        val navContact = findViewById<Button>(R.id.navContact)
        val btnBack = findViewById<ImageView>(R.id.btnBack)

        btnBack.setOnClickListener {
            finish()
        }

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

        // ===== COURSES (TOGGLE DESCRIPTIONS) =====

        setupToggle(R.id.courseBox4, R.id.courseDescription4)
        setupToggle(R.id.courseBox5, R.id.courseDescription5)
        setupToggle(R.id.courseBox6, R.id.courseDescription6)
        setupToggle(R.id.courseBox7, R.id.courseDescription7)
    }

    private fun setupToggle(boxId: Int, descId: Int) {
        val box = findViewById<LinearLayout>(boxId)
        val desc = findViewById<TextView>(descId)

        box.setOnClickListener {
            desc.visibility =
                if (desc.visibility == View.GONE) View.VISIBLE else View.GONE
        }
    }
}