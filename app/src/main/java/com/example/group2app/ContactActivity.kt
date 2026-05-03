package com.example.group2app

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.net.URL
import kotlin.concurrent.thread

class ContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        // ===== NAVIGATION =====
        val navHome = findViewById<Button>(R.id.navHome)
        val navQuote = findViewById<Button>(R.id.navQuote)
        val navContact = findViewById<Button>(R.id.navContact)

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

        // ===== STATIC MAP LINKS =====
        val mapImages = arrayOf(
            "https://maps.googleapis.com/maps/api/staticmap?center=Sandton,Johannesburg&zoom=15&size=600x300&markers=color:red|Sandton",
            "https://maps.googleapis.com/maps/api/staticmap?center=Rosebank,Johannesburg&zoom=15&size=600x300&markers=color:red|Rosebank",
            "https://maps.googleapis.com/maps/api/staticmap?center=Braamfontein,Johannesburg&zoom=15&size=600x300&markers=color:red|Braamfontein"
        )

        fun loadMap(url: String) {
            thread {
                try {
                    val stream = URL(url).openStream()
                    val bitmap = BitmapFactory.decodeStream(stream)
                    runOnUiThread {
                        mapImage.setImageBitmap(bitmap)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        // initial load
        loadMap(mapImages[0])

        // ===== SPINNER =====
        val venues = arrayOf(
            "Sandton Campus - 5th Street",
            "Rosebank Training Centre",
            "Braamfontein Skills Hub"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            venues
        )

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                loadMap(mapImages[position])
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