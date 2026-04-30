package com.example.group2app

import android.os.Bundle
import android.webkit.WebView
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class ContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        val navHome = findViewById<Button>(R.id.navHome)
        val navQuote = findViewById<Button>(R.id.navQuote)

        navHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        navQuote.setOnClickListener {
            val intent = Intent(this, QuoteActivity::class.java)
            startActivity(intent)
        }

        val spinner = findViewById<Spinner>(R.id.venueSpinner)
        val mapView = findViewById<WebView>(R.id.mapView)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val messageInput = findViewById<EditText>(R.id.messageInput)
        val submitBtn = findViewById<Button>(R.id.submitBtn)

        // ✅ VENUES (Johannesburg)
        val venues = arrayOf(
            "Sandton Campus - 5th Street, Sandton",
            "Rosebank Training Centre - Oxford Road",
            "Braamfontein Skills Hub - Juta Street"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, venues)
        spinner.adapter = adapter

        // ✅ MAP SETUP
        mapView.settings.javaScriptEnabled = true

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View?, position: Int, id: Long) {

                val mapLinks = arrayOf(
                    "https://www.google.com/maps?q=Sandton+Johannesburg&output=embed",
                    "https://www.google.com/maps?q=Rosebank+Johannesburg&output=embed",
                    "https://www.google.com/maps?q=Braamfontein+Johannesburg&output=embed"
                )

                mapView.loadUrl(mapLinks[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        // ✅ FORM VALIDATION
        submitBtn.setOnClickListener {

            val name = nameInput.text.toString()
            val email = emailInput.text.toString()
            val message = messageInput.text.toString()

            if (name.isEmpty()) {
                nameInput.error = "Name required"
                return@setOnClickListener
            }

            if (email.isEmpty() || !email.contains("@")) {
                emailInput.error = "Valid email required"
                return@setOnClickListener
            }

            if (message.isEmpty()) {
                messageInput.error = "Message required"
                return@setOnClickListener
            }

            Toast.makeText(this, "Message sent successfully!", Toast.LENGTH_LONG).show()
        }
    }
}