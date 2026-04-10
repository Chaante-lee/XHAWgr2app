package com.example.group2app

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent

class CoursesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        val navHome = findViewById<Button>(R.id.navHome)

        navHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        // ----- Course 1 -----
        val courseBox1 = findViewById<LinearLayout>(R.id.courseBox1)
        val courseDescription1 = findViewById<TextView>(R.id.courseDescription1)

        courseBox1.setOnClickListener {
            courseDescription1.visibility =
                if (courseDescription1.visibility == View.GONE) View.VISIBLE else View.GONE
        }

        // ----- Course 2 -----
        val courseBox2 = findViewById<LinearLayout>(R.id.courseBox2)
        val courseDescription2 = findViewById<TextView>(R.id.courseDescription2)

        courseBox2.setOnClickListener {
            courseDescription2.visibility =
                if (courseDescription2.visibility == View.GONE) View.VISIBLE else View.GONE
        }

        // ----- Course 3 -----
        val courseBox3 = findViewById<LinearLayout>(R.id.courseBox3)
        val courseDescription3 = findViewById<TextView>(R.id.courseDescription3)

        courseBox3.setOnClickListener {
            courseDescription3.visibility =
                if (courseDescription3.visibility == View.GONE) View.VISIBLE else View.GONE
        }

        // ===== 6 MONTH COURSES =====

        // ----- Course 4 -----
        val courseBox4 = findViewById<LinearLayout>(R.id.courseBox4)
        val courseDescription4 = findViewById<TextView>(R.id.courseDescription4)

        courseBox4.setOnClickListener {
            courseDescription4.visibility =
                if (courseDescription4.visibility == View.GONE) View.VISIBLE else View.GONE
        }

        // ----- Course 5 -----
        val courseBox5 = findViewById<LinearLayout>(R.id.courseBox5)
        val courseDescription5 = findViewById<TextView>(R.id.courseDescription5)

        courseBox5.setOnClickListener {
            courseDescription5.visibility =
                if (courseDescription5.visibility == View.GONE) View.VISIBLE else View.GONE
        }

        // ----- Course 6 -----
        val courseBox6 = findViewById<LinearLayout>(R.id.courseBox6)
        val courseDescription6 = findViewById<TextView>(R.id.courseDescription6)

        courseBox6.setOnClickListener {
            courseDescription6.visibility =
                if (courseDescription6.visibility == View.GONE) View.VISIBLE else View.GONE
        }

        // ----- Course 7 -----
        val courseBox7 = findViewById<LinearLayout>(R.id.courseBox7)
        val courseDescription7 = findViewById<TextView>(R.id.courseDescription7)

        courseBox7.setOnClickListener {
            courseDescription7.visibility =
                if (courseDescription7.visibility == View.GONE) View.VISIBLE else View.GONE
        }
    }
}