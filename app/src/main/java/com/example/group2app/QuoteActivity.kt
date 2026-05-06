package com.example.group2app

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.util.Patterns

class QuoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)

        // NAVIGATION
        val navHome = findViewById<Button>(R.id.navHome)
        val navContact = findViewById<Button>(R.id.navContact)
        val btnBack = findViewById<ImageView>(R.id.btnBack)

        btnBack.setOnClickListener {
            finish()
        }

        navHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        navContact.setOnClickListener {
            startActivity(Intent(this, ContactActivity::class.java))
        }

        // COURSE CHECKBOXES
        val course1 = findViewById<CheckBox>(R.id.course1)
        val course2 = findViewById<CheckBox>(R.id.course2)
        val course3 = findViewById<CheckBox>(R.id.course3)
        val course4 = findViewById<CheckBox>(R.id.course4)
        val course5 = findViewById<CheckBox>(R.id.course5)
        val course6 = findViewById<CheckBox>(R.id.course6)
        val course7 = findViewById<CheckBox>(R.id.course7)

        // INPUT FIELDS
        val nameInput = findViewById<EditText>(R.id.nameInput)
        val phoneInput = findViewById<EditText>(R.id.phoneInput)
        val emailInput = findViewById<EditText>(R.id.emailInput)

        val calcButton = findViewById<Button>(R.id.calcButton)
        val totalText = findViewById<TextView>(R.id.totalText)

        // OPTIONAL: Clear errors when user clicks field
        nameInput.setOnFocusChangeListener { _, _ -> nameInput.error = null }
        phoneInput.setOnFocusChangeListener { _, _ -> phoneInput.error = null }
        emailInput.setOnFocusChangeListener { _, _ -> emailInput.error = null }

        calcButton.setOnClickListener {

            // GET VALUES
            val name = nameInput.text.toString().trim()
            val phone = phoneInput.text.toString().trim()
            val email = emailInput.text.toString().trim()

            var isValid = true

            // NAME VALIDATION
            if (name.isEmpty()) {
                nameInput.error = "Full name is required"
                isValid = false
            }

            // PHONE VALIDATION
            if (phone.isEmpty()) {
                phoneInput.error = "Phone number is required"
                isValid = false
            } else if (phone.length < 10) {
                phoneInput.error = "Enter a valid phone number"
                isValid = false
            }

            // EMAIL VALIDATION
            if (email.isEmpty()) {
                emailInput.error = "Email is required"
                isValid = false
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailInput.error = "Enter a valid email"
                isValid = false
            }

            // COURSE VALIDATION
            if (!course1.isChecked && !course2.isChecked && !course3.isChecked &&
                !course4.isChecked && !course5.isChecked && !course6.isChecked && !course7.isChecked) {

                totalText.text = "⚠ Please select at least one course"
                isValid = false
            }

            // STOP if invalid
            if (!isValid) return@setOnClickListener

            // CALCULATION
            val selectedCourses = ArrayList<String>()
            var total = 0

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

            // DISCOUNT
            var discount = 0.0
            when {
                count == 2 -> discount = 0.05
                count == 3 -> discount = 0.10
                count > 3 -> discount = 0.15
            }

            val discountAmount = total * discount
            val discountedTotal = total - discountAmount

            // VAT
            val vat = discountedTotal * 0.15
            val finalTotal = discountedTotal + vat

            totalText.text = "Total (incl VAT & discount): R%.2f".format(finalTotal)
        }
    }
}