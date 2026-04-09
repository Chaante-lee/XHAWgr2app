package com.example.group2app

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses) // make sure this XML exists

        // ----- Course 1 -----
        val courseBox1 = findViewById<LinearLayout>(R.id.courseBox1)
        val courseDescription1 = findViewById<TextView>(R.id.courseDescription1)

        courseBox1.setOnClickListener {
            courseDescription1.visibility = if (courseDescription1.visibility == View.GONE) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }

        // ----- Course 2 -----
        val courseBox2 = findViewById<LinearLayout>(R.id.courseBox2)
        val courseDescription2 = findViewById<TextView>(R.id.courseDescription2)

        courseBox2.setOnClickListener {
            courseDescription2.visibility = if (courseDescription2.visibility == View.GONE) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }

        // ----- Course 3 -----
        val courseBox3 = findViewById<LinearLayout>(R.id.courseBox3)
        val courseDescription3 = findViewById<TextView>(R.id.courseDescription3)

        courseBox3.setOnClickListener {
            courseDescription3.visibility = if (courseDescription3.visibility == View.GONE) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }
}