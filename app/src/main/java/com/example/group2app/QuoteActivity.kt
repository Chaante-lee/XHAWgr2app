package com.example.group2app

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class QuoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)


        val navHome = findViewById<Button>(R.id.navHome)
        val navContact = findViewById<Button>(R.id.navContact)

        navHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        navContact.setOnClickListener {
            startActivity(Intent(this, ContactActivity::class.java))
        }

        navHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        val course1 = findViewById<CheckBox>(R.id.course1)
        val course2 = findViewById<CheckBox>(R.id.course2)
        val course3 = findViewById<CheckBox>(R.id.course3)
        val course4 = findViewById<CheckBox>(R.id.course4)
        val course5 = findViewById<CheckBox>(R.id.course5)
        val course6 = findViewById<CheckBox>(R.id.course6)
        val course7 = findViewById<CheckBox>(R.id.course7)

        val calcButton = findViewById<Button>(R.id.calcButton)
        val totalText = findViewById<TextView>(R.id.totalText)

        calcButton.setOnClickListener {

            val selectedCourses = ArrayList<String>()
            var total = 0

            // ✅ ADD COURSES + PRICES
            if (course1.isChecked) {
                selectedCourses.add("Child Minding")
                total += 750
            }
            if (course2.isChecked) {
                selectedCourses.add("Cooking")
                total += 750
            }
            if (course3.isChecked) {
                selectedCourses.add("Garden Maintenance")
                total += 750
            }
            if (course4.isChecked) {
                selectedCourses.add("First Aid")
                total += 1500
            }
            if (course5.isChecked) {
                selectedCourses.add("Sewing")
                total += 1500
            }
            if (course6.isChecked) {
                selectedCourses.add("Landscaping")
                total += 1500
            }
            if (course7.isChecked) {
                selectedCourses.add("Life Skills")
                total += 1500
            }

            val count = selectedCourses.size

            // ✅ DISCOUNT LOGIC
            var discount = 0.0
            when {
                count == 2 -> discount = 0.05
                count == 3 -> discount = 0.10
                count > 3 -> discount = 0.15
            }

            val discountAmount = total * discount
            val discountedTotal = total - discountAmount

            // ✅ VAT 15%
            val vat = discountedTotal * 0.15
            val finalTotal = discountedTotal + vat

            totalText.text = "Total (incl VAT & discount): R%.2f".format(finalTotal)

            // ✅ You now have:
            // selectedCourses ARRAY for invoice use later
        }
    }
}