package com.example.group2app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

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

        // ===== VIEWS =====
        val spinner = findViewById<Spinner>(R.id.venueSpinner)
        val mapImage = findViewById<ImageView>(R.id.mapImage)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val messageInput = findViewById<EditText>(R.id.messageInput)
        val submitBtn = findViewById<Button>(R.id.submitBtn)

        // ===== LOCATIONS =====
        val venues = arrayOf(
            "Sandton Campus - 161 Maude Street",
            "Rosebank Training Centre",
            "Braamfontein Skills Hub"
        )

        val locations = arrayOf(
            "161 Maude St, Sandown, Sandton, 2196",
            "Corner Tyrwhitt and, 24 Cradock Ave, Rosebank, Johannesburg, 2196",
            "Harrison St, Wanderers View Estate, Johannesburg, 2193"
        )

        spinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            venues
        )

        // ===== OPEN GOOGLE MAPS ON IMAGE CLICK =====
        var selectedLocation = locations[0]

        mapImage.setOnClickListener {
            val url = "https://www.google.com/maps/search/?api=1&query=$selectedLocation"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        // ===== SPINNER HANDLER =====
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedLocation = locations[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        // ===== FORM VALIDATION =====
        submitBtn.setOnClickListener {

            val name = nameInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val message = messageInput.text.toString().trim()

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

            nameInput.text.clear()
            emailInput.text.clear()
            messageInput.text.clear()
        }
    }
}