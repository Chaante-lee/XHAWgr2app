package com.example.etn

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class FeesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fees)


        val firstAid = findViewById<CheckBox>(R.id.cbFirstAid)
        val sewing = findViewById<CheckBox>(R.id.cbSewing)
        val landscaping = findViewById<CheckBox>(R.id.cbLandscaping)
        val lifeSkills = findViewById<CheckBox>(R.id.cbLifeSkills)
        val childMinding = findViewById<CheckBox>(R.id.cbChildMinding)
        val cooking = findViewById<CheckBox>(R.id.cbCooking)
        val gardenMaintenance = findViewById<CheckBox>(R.id.cbGardenMaintenance)

        // Matching the Display Text and Button IDs
        val resultText = findViewById<TextView>(R.id.txtRunningTotal)
        val discountText = findViewById<TextView>(R.id.txtDiscountNote)
        val calculateBtn = findViewById<Button>(R.id.btnCalculateAndProceed)
        val backBtn = findViewById<ImageView>(R.id.btnBackFromFees)

        backBtn.setOnClickListener { finish() }

        calculateBtn.setOnClickListener {
            var total = 0
            var count = 0

            // 6-Month Courses (R1500)
            if (firstAid.isChecked) { total += 1500; count++ }
            if (sewing.isChecked) { total += 1500; count++ }
            if (landscaping.isChecked) { total += 1500; count++ }
            if (lifeSkills.isChecked) { total += 1500; count++ }

            // 6-Week Courses (R750)
            if (childMinding.isChecked) { total += 750; count++ }
            if (cooking.isChecked) { total += 750; count++ }
            if (gardenMaintenance.isChecked) { total += 750; count++ }

            // Discounts based on count
            val discountPercent = when {
                count == 2 -> 0.05
                count == 3 -> 0.10
                count > 3 -> 0.15
                else -> 0.0
            }

            val discountAmount = total * discountPercent
            val finalTotal = total - discountAmount

            // Update the UI
            resultText.text = "Total Amount: R ${String.format("%.2f", finalTotal)}"

            if (discountPercent > 0) {
                discountText.text = "${(discountPercent * 100).toInt()}% Discount Applied! Saved R ${String.format("%.2f", discountAmount)}"
            } else {
                discountText.text = "No discount applied yet"
            }

            Toast.makeText(this, "Quote Generated!", Toast.LENGTH_SHORT).show()
        }
    }
}