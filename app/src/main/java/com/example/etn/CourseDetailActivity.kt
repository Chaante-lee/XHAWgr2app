package com.example.etn

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CourseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)

        // 1. UNPACK: Grab the data sent from CoursesActivity
        val title = intent.getStringExtra("COURSE_TITLE") ?: "Course"
        val price = intent.getStringExtra("COURSE_PRICE") ?: "N/A"
        val skills = intent.getStringExtra("COURSE_SKILLS") ?: "Skills list not found."
        val description = intent.getStringExtra("COURSE_DESCRIPTION") ?: "Description not found."
        val imageRes = intent.getIntExtra("COURSE_IMAGE", 0)

        // 2. CONNECT: Link variables to your XML IDs
        val titleView = findViewById<TextView>(R.id.detailTitle)
        val priceView = findViewById<TextView>(R.id.detailPrice)
        val descView = findViewById<TextView>(R.id.detailDescription)
        val skillsView = findViewById<TextView>(R.id.detailSkills)
        val imageView = findViewById<ImageView>(R.id.detailImage)
        val backBtn = findViewById<ImageView>(R.id.backButtonDetail)

        // 3. DISPLAY: Overwrite the XML placeholders with real data
        titleView.text = title
        priceView.text = price
        descView.text = description
        skillsView.text = skills

        if (imageRes != 0) {
            imageView.setImageResource(imageRes)
        }

        // 4. NAVIGATE: Button listeners
        backBtn.setOnClickListener { finish() }

        findViewById<Button>(R.id.feesBtn).setOnClickListener {
            startActivity(Intent(this, FeesActivity::class.java))
        }

        findViewById<Button>(R.id.contactBtn).setOnClickListener {

            startActivity(Intent(this, ContactActivity::class.java))
        }
    }
}