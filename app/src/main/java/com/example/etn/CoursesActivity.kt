package com.example.etn

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CoursesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        findViewById<ImageView>(R.id.backButton).setOnClickListener { finish() }

        // --- SIX-MONTH COURSES ---
        findViewById<Button>(R.id.btnFirstAid).setOnClickListener {
            openDetail(
                "First Aid",
                "R 1,500",
                "• CPR & AED\n• Wound Care\n• Choking & Blockages\n• Trauma Response",
                "Our First Aid course provides essential life-saving skills for emergency situations in both home and work environments.",
                R.drawable.firstaid
            )
        }

        findViewById<Button>(R.id.btnSewing).setOnClickListener {
            openDetail(
                "Sewing",
                "R 1,500",
                "• Machine Threading\n• Pattern Cutting\n• Garment Assembly\n• Alterations",
                "Master the fundamentals of garment construction. This course takes you from basic stitches to creating your own clothing.",
                R.drawable.sewing
            )
        }

        findViewById<Button>(R.id.btnLandscaping).setOnClickListener {
            openDetail(
                "Landscaping",
                "R 1,500",
                "• Soil Preparation\n• Garden Design\n• Plant Selection\n• Irrigation Setup",
                "Learn to transform outdoor spaces. This course covers the aesthetic and functional aspects of professional gardening.",
                R.drawable.landscaping
            )
        }

        findViewById<Button>(R.id.btnLifeSkills).setOnClickListener {
            openDetail(
                "Life Skills",
                "R 1,500",
                "• Financial Literacy\n• CV Writing\n• Interview Skills\n• Time Management",
                "Prepare for the professional world with essential skills for personal and career development.",
                R.drawable.lifeskills
            )
        }

        // --- SIX-WEEK COURSES ---
        findViewById<Button>(R.id.btnChildMinding).setOnClickListener {
            openDetail(
                "Child Minding",
                "R 750",
                "• Child Safety\n• Infant Nutrition\n• Early Childhood Play\n• First Aid Basics",
                "A practical course for those looking to provide high-quality care for children and infants.",
                R.drawable.childminding
            )
        }

        findViewById<Button>(R.id.btnCooking).setOnClickListener {
            openDetail(
                "Cooking",
                "R 750",
                "• Knife Skills\n• Menu Planning\n• Food Hygiene\n• Baking Basics",
                "Discover the joy of cooking. This short course focuses on kitchen safety and preparing healthy, delicious meals.",
                R.drawable.cooking
            )
        }

        findViewById<Button>(R.id.btnGardenMaintenance).setOnClickListener {
            openDetail(
                "Garden Maintenance",
                "R 750",
                "• Mowing & Edging\n• Pruning Techniques\n• Tool Maintenance\n• Pest Control",
                "Learn the essential tasks required to keep residential gardens looking professional and healthy.",
                R.drawable.gardenmaintenance
            )
        }

        findViewById<Button>(R.id.viewQuoteBtn).setOnClickListener {
            startActivity(Intent(this, FeesActivity::class.java))
        }
    }

    private fun openDetail(title: String, price: String, skills: String, info: String, img: Int) {
        val intent = Intent(this, CourseDetailActivity::class.java).apply {
            putExtra("COURSE_TITLE", title)
            putExtra("COURSE_PRICE", price)
            putExtra("COURSE_SKILLS", skills)
            putExtra("COURSE_DESCRIPTION", info)
            putExtra("COURSE_IMAGE", img)
        }
        startActivity(intent)
    }
}